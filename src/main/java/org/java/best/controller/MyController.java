package org.java.best.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String getBest(Model model) {
		
		model.addAttribute("nome", "Robert");
		
		return "index";
	}
	
	@GetMapping("/movies")
	public String getMovies(Model model) {
		
		String str1 = "";
		
		Iterator<Movie> i1 = getBestMovies().iterator();
		
		while(i1.hasNext()) {
			
			str1 += i1.next().getTitolo();
			
			if (i1.hasNext()) {
				
				str1 += ", ";
			}
			else {
				str1 += ".";
			}
		}
		
		model.addAttribute("movies", str1);
		
		return "movies";
	}
	
	@GetMapping("/songs")
	public String getSongs(Model model) {
		
		String str2 = "";
		
		Iterator<Song> i2 = getBestSongs().iterator();
		
		while(i2.hasNext()) {
			
			str2 += i2.next().getTitolo();
			
			if (i2.hasNext()) {
				
				str2 += ", ";
			}
			else {
				str2 += ".";
			}
		}
		
		model.addAttribute("songs", str2);
		
		return "songs";
	}
	
	@GetMapping("/movies/{id}")
	public String getIdMovie(Model model, @PathVariable("id") int id) {
		
		Integer resId = null;
		String resT = null;
		
		for (Movie m : getBestMovies()) {
			
			if (m.getId() == id) {
				
				resId = m.getId();
				resT = m.getTitolo();
			}
		}
		
		model.addAttribute("id", resId);
		model.addAttribute("movie", resT);
		
		return "movie-id";
	}
	
	@GetMapping("/songs/{id}")
	public String getIdSong(Model model, @PathVariable("id") int id) {
		
		Integer resId = null;
		String resT = null;
		
		for (Song s : getBestSongs()) {
			
			if (s.getId() == id) {
				
				resId = s.getId();
				resT = s.getTitolo();
			}
		}
		
		model.addAttribute("id", resId);
		model.addAttribute("song", resT);
		
		return "song-id";
	}
	
	
	private List<Movie> getBestMovies() {
		
		Movie m1 = new Movie(0, "AAAAA");
		Movie m2 = new Movie(1, "BBBBB");
		Movie m3 = new Movie(2, "CCCCC");
		
		List<Movie> movies = new ArrayList<>();
		
		movies.add(m1);
		movies.add(m2);
		movies.add(m3);		
		
		return movies;		
	}
	
	private List<Song> getBestSongs() {
		
		Song s1 = new Song(0, "XXXXX");
		Song s2 = new Song(1, "YYYYY");
		Song s3 = new Song(2, "ZZZZZ");
		
		List<Song> songs = new ArrayList<>();
		
		songs.add(s1);
		songs.add(s2);
		songs.add(s3);		
		
		return songs;		
	}
}

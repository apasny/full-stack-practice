package com.apasny.fullstackpractice.controller;

import com.apasny.fullstackpractice.entity.Movie;
import com.apasny.fullstackpractice.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> allMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Movie> getMovie(@PathVariable String imdbId){
        return ResponseEntity.ok(movieService.getMovieById(imdbId));
    }
}

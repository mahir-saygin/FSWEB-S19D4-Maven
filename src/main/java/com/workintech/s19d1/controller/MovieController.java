package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@Slf4j
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable Long id) {
        return movieService.findById(id);
    }

    @PostMapping
    public Movie save(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @RequestBody Movie movie) {
        Movie existingMovie = movieService.findById(id);

        existingMovie.setName(movie.getName());
        existingMovie.setDirectorName(movie.getDirectorName());
        existingMovie.setRating(movie.getRating());
        existingMovie.setReleaseDate(movie.getReleaseDate());

        return movieService.save(existingMovie);
    }

    @DeleteMapping("/{id}")
    public Movie delete(@PathVariable Long id) {
        Movie movie = movieService.findById(id);

        movieService.delete(movie);

        return movie;
    }
}
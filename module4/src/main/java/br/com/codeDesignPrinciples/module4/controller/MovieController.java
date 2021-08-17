package br.com.codeDesignPrinciples.module4.controller;


import br.com.codeDesignPrinciples.module4.entity.Movie;
import br.com.codeDesignPrinciples.module4.service.iMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

@RestController
@RequestMapping("/v1/movies")
public class MovieController {
    private final LinkedHashSet<Movie> all;
    private final LinkedHashSet<Movie> findGenre;

    @Autowired
    private final iMovieService movieService;

    public MovieController(iMovieService movieService){
        this.movieService = movieService;
        this.all = new LinkedHashSet<>();
        this.findGenre = new LinkedHashSet<>();
    }

    @GetMapping
    public ResponseEntity<LinkedHashSet<Movie>> all(@RequestParam(required = false) Movie movie){
        return new ResponseEntity( movieService.all(movie), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public Movie findId(@RequestParam("id") Long id){
        return movieService.withId(id);
    }
    @GetMapping("{name}")
    public Movie findName(@RequestParam("name") String name){
        return movieService.withName(name);
    }
    @GetMapping("{genre}")
    public LinkedHashSet<Movie> findGenre(@RequestParam(required = false) String genre){
        return (LinkedHashSet<Movie>) movieService.findGenre(genre);
    }

    @PostMapping
    public ResponseEntity<Movie> add(@RequestBody final Movie movie){
        movieService.add(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity updateName(@RequestBody final Movie title){
        movieService.updateName(title);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        movieService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

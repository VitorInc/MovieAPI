package br.com.codeDesignPrinciples.module4.service;

import br.com.codeDesignPrinciples.module4.entity.Movie;

import java.util.LinkedHashSet;
import java.util.List;

public interface iMovieService {

    LinkedHashSet<Movie> all(Movie movies);
    Movie withName(String name);
    LinkedHashSet <Movie>findGenre(String genre);
    Movie withId(Long id);
    Movie add(final Movie movies);
    void updateName(final Movie title);
    void updateGenre(final Movie genre);
    void updateDirector(final Movie director);
    void updateYear(final Movie year);
    void updateRate(final  Movie rate);
    void delete(Long id);



}

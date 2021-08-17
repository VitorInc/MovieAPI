package br.com.codeDesignPrinciples.module4.service;

import br.com.codeDesignPrinciples.module4.entity.Movie;
import br.com.codeDesignPrinciples.module4.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
@Service
public class MovieService implements iMovieService {

    @Autowired
    private MovieRepository movieRepositoy;

    public LinkedHashSet<Movie> all(Movie movies){
        if(movies != null){
            return movieRepositoy.allMovies(movies);
        }
        return  movieRepositoy.allMovies();
    }
    public Movie withName(String name){
        return movieRepositoy.findName(name);
    }

    @Override
    public LinkedHashSet<Movie> findGenre(String genre) {
        return (LinkedHashSet<Movie>) movieRepositoy.findGenre(genre);
    }

    public Movie withId(Long id){
        return movieRepositoy.findId(id);
    }



    public Movie add(final Movie movies){
        return movieRepositoy.add(movies);
    }

    public void updateName(final Movie title){
        movieRepositoy.updateName(title);
    }
    public void updateGenre(final Movie genre){
        movieRepositoy.updateGenre(genre);
    }
    public void updateDirector(final Movie director){
        movieRepositoy.updateDirector(director);
    }
    public void updateYear(final Movie year){
        movieRepositoy.updateYear(year);
    }
    public void updateRate(final  Movie rate){
        movieRepositoy.updateRate(rate);
    }
    public void delete(Long id){
        movieRepositoy.delete(id);
    }

}

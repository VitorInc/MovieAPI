package br.com.codeDesignPrinciples.module4.repository;

import br.com.codeDesignPrinciples.module4.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieRepository {

    final Logger LOGGER = LoggerFactory.getLogger(MovieRepository.class);
    private List<Movie> movieList = new ArrayList<>();

    public List<Movie> allMovies(){
        return movieList;
    }
    public List<Movie> allMovies(Movie movies){
        return allMovies().
                stream().
                filter(movies1 -> movies.
                        getName().
                        contains((CharSequence) movies))
                .collect(Collectors.toList());
    }

    public Movie add(Movie movies){
    if(movieList.contains(movies.getId())){
        LOGGER.error("Not allowed to add moves with same id ");
    }else if(movieList.equals(movies.getName()) && movieList.equals(movies.getYear()) && movieList.equals(movies.getDirector()) && movieList.equals(movies.getGenre())){
        LOGGER.error("Not allowed movies with same info(name, year, director,genre)");
    }else if(movies.getRate()>=0 && movies.getRate()<=5){
        this.movieList.add(movies);
    }
    return movies;
    }

    public void updateName(final Movie movies){
        movieList.stream().filter(movie -> movies.getId().equals(movies.getId())).
                forEach(movie -> movie.setName(movies.getName()));
    }
    public void updateDirector(final Movie movies){
        movieList.stream().filter(movie -> movies.getId().equals(movies.getId())).
                forEach(movie -> movie.setDirector(movies.getDirector()));
    }
    public void updateYear(final Movie movies){
        movieList.stream().filter(movie -> movie.getId().equals(movies.getId())).
                forEach(movie -> movie.setYear(movies.getYear()));
    }
    public void updateGenre(final Movie movies){
        movieList.stream().filter(movie -> movie.getId().equals(movies.getId())).
                forEach(movie -> movie.setRate(movie.getRate()));
    }
    public Movie findId(Long id){
        return this.movieList.
                stream().filter(movie -> movie.getId().equals(id))
                .findFirst().orElse(null);
    }

    public void delete( Long id) {
        movieList.removeIf(movie -> movie.getId().equals(id));
    }
}

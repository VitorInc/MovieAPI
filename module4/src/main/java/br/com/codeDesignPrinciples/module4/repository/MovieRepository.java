package br.com.codeDesignPrinciples.module4.repository;

import br.com.codeDesignPrinciples.module4.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {


    private LinkedHashSet<Movie> movieList = new LinkedHashSet<>();

    public LinkedHashSet<Movie> allMovies(){
        return movieList;
    }
    public LinkedHashSet<Movie> allMovies(Movie movies){
        return (LinkedHashSet<Movie>) movieList.
                stream().
                filter(movie -> movie.
                        getName().
                        contains((CharSequence) movies))
                .collect(Collectors.toList());
    }

    public Movie add(Movie movies)  {
    if(movieList.contains(movies.getId())){
        System.out.println("not possible");
    }else if(movieList.equals(movies.getName()) &&
            movieList.equals(movies.getYear()) &&
            movieList.equals(movies.getDirector())){
        System.out.println("not possible");
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
    public void updateRate(final Movie movies){
        movieList.stream().filter(movie -> movie.getRate().equals(movies.getRate())).
                forEach(movie -> movie.setRate(movie.getRate()));
    }
    public Movie findId(Long id){
        return this.movieList.
                stream().filter(movie -> movie.getId().equals(id))
                .findFirst().orElse(null);
    }
    public Movie  findName(String name){
        return this.movieList.
                stream().filter(movie -> movie.getName().equals(name))
                .findFirst().orElse(null);
    }
    public LinkedHashSet <Movie>  findGenre(String genre){
        return (LinkedHashSet<Movie>) this.movieList.stream().filter(movie -> movie.getGenre().contains(genre))
                .collect(Collectors.toList());
    }


    public void delete( Long id) {
        movieList.removeIf(movie -> movie.getId().equals(id));
    }
}

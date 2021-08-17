package br.com.codeDesignPrinciples.module4.entity;

import java.util.Objects;

public class Movie {
    private Long id;
    private String name;
    private Integer year;
    private String genre;
    private String director;
    private Float rate;

    public Movie(){}

    public Movie(Long id,String name, Integer year, String genre, String director, Float rate) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Float getRate() {
        if(rate <=5.0){
        return rate;
        }
        else return null;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(getName(), movie.getName()) && Objects.equals(getGenre(), movie.getGenre()) && Objects.equals(getDirector(), movie.getDirector()) && Objects.equals(getRate(), movie.getRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDirector());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", rate=" + rate +
                '}';
    }
}

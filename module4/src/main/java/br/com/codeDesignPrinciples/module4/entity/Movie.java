package br.com.codeDesignPrinciples.module4.entity;

public class Movie {
    private String name;
    private Integer year;
    private String genre;
    private String director;
    private Float rate;

    public Movie(){}

    public Movie(String name, Integer year, String genre, String director, Float rate) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.rate = rate;
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
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", rate=" + rate +
                '}';
    }
}

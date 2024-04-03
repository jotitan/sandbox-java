package fr.titan.pdf.model;

import java.util.Arrays;
import java.util.List;

public class MovieBean{
    private String title;
    private int year;
    private String director;
    private List<String> actors;

    public MovieBean(){}

    public MovieBean(String title, int year, String director, List<String> actors) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.actors = actors;
    }

    public static MovieBean from(Movie m) {
        return new MovieBean(m.title(), m.year(), m.director(), m.actors());
    }

    public static List<MovieBean> movies() {
        return Arrays.stream(Movie.movies()).map(MovieBean::from).toList();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

}

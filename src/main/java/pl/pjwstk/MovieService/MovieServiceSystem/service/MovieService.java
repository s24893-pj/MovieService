package pl.pjwstk.MovieService.MovieServiceSystem.service;

import org.springframework.stereotype.Service;
import pl.pjwstk.MovieService.MovieServiceSystem.template.Movie;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private final List<Movie> movies = new ArrayList<>();

    public MovieService() {
        movies.add(new Movie("Cronos", "Horror", 1993));
        movies.add(new Movie("Martin", "Horror", 1976));
        movies.add(new Movie("The Fall", "Fantasy", 2006));
        movies.add(new Movie("Godmothered", "Fantasy", 2020));
        movies.add(new Movie("Let Him Go", "Thriller", 2020));
        movies.add(new Movie("Windfall", "Thriller", 2022));
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public Movie getById(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void deleteMovie(int id){
        Movie movie = getById(id);
        if (movie != null){
            movies.remove(movie);
        }else {
            throw new IllegalArgumentException("film o id " + id + " nie istnieje");
        }
    }

    public void updateMovie(Movie m){
        Movie movie = getById(m.getId());
        if(movie != null){
            if(m.getName() != null){
                movie.setName(m.getName());
            }
            if(m.getCategory() != null){
                movie.setCategory(m.getCategory());
            }
            if (m.getYear() != 0){
                movie.setYear(m.getYear());
            }
        }else {
            throw new IllegalArgumentException("film o id " + m.getId() + " nie istnieje");
        }
    }

}

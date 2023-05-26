package pl.pjwstk.MovieService.MovieServiceSystem.service;

import org.springframework.stereotype.Service;
import pl.pjwstk.MovieService.MovieRepository;
import pl.pjwstk.MovieService.MovieServiceSystem.template.Movie;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final List<Movie> movies = new ArrayList<>();

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie getById(long id) {
        for (Movie movie : movieRepository.findAll()) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void deleteMovie(long id){
        Movie movie = getById(id);
        if (movie != null){
            movieRepository.delete(movie);
        }else {
            throw new IllegalArgumentException("film o id " + id + " nie istnieje");
        }
    }

    public void updateMovie(long id, Movie m){
        Movie movie = movieRepository.getById(id);
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

    public void setStatus(Long id, boolean status){
        movieRepository.updateAvailableStatus(id, status);
    }

}

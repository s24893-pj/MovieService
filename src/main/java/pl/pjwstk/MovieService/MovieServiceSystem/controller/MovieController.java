package pl.pjwstk.MovieService.MovieServiceSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjwstk.MovieService.MovieServiceSystem.service.MovieService;
import pl.pjwstk.MovieService.MovieServiceSystem.template.Movie;

import java.util.List;


@RestController
    @RequestMapping("/movieservice")
    public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

        @GetMapping("/movies")
        public ResponseEntity<List<Movie>> GetMovies(){
            return ResponseEntity.ok(movieService.getAllMovies());
        }

        @GetMapping("/movies/{id}")
        public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
            if (movieService.getById(id) != null) {
                return ResponseEntity.ok(movieService.getById(id));
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping("/movies")
        public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
            if (movie != null) {
                movieService.addMovie(movie);
                return ResponseEntity.ok(movie);
            } else {
                return ResponseEntity.badRequest().build();
            }
        }

        @PutMapping("/movies/{id}")
        public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestBody Movie movie) {
            if (getMovieById(id) != null) {
                movie.setId(id);
                movieService.updateMovie(movie);
                return ResponseEntity.ok(movie);
            } else {
                return ResponseEntity.badRequest().build();
            }
        }

        @DeleteMapping("/movies/{id}")
        public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
            if(getMovieById(id) != null){
                movieService.deleteMovie(id);
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.notFound().build();
            }
        }

    }

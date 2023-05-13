package pl.pjwstk.MovieService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.pjwstk.MovieService.MovieServiceSystem.template.Movie;
import pl.pjwstk.MovieService.MovieServiceSystem.service.MovieService;

@SpringBootApplication
public class MovieServiceApplication {

	public MovieServiceApplication(MovieService movieService) {
		movieService.addMovie(new Movie("Harry Potter", "Fantasy", 1997));
		movieService.addMovie(new Movie("Fast and Furious", "Action", 2001));
		movieService.addMovie(new Movie("Matrix", "Science Fiction", 1999));
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}


}

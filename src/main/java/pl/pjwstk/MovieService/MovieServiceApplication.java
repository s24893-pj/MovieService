package pl.pjwstk.MovieService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.pjwstk.MovieService.MovieServiceSystem.template.Movie;
import pl.pjwstk.MovieService.MovieServiceSystem.service.MovieService;

import static pl.pjwstk.MovieService.MovieServiceSystem.template.Movie.Category.*;

@SpringBootApplication
public class MovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}


}

package pl.pjwstk.MovieService;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjwstk.MovieService.MovieServiceSystem.template.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie getById(long id);

    void updateAvailableStatus(Long id, boolean status);
}

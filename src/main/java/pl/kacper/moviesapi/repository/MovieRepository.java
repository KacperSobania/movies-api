package pl.kacper.moviesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kacper.moviesapi.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}

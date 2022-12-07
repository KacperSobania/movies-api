package pl.kacper.moviesapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kacper.moviesapi.dto.MovieDto;
import pl.kacper.moviesapi.entity.Movie;
import pl.kacper.moviesapi.repository.MovieRepository;
import pl.kacper.moviesapi.webclient.movie.MovieClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieClient movieClient;

    public MovieDto getMovieByTitle(String title){
        return movieClient.getMovieByTitle(title);
    }

    public Movie addFavouriteMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public List<Movie> getFavouriteMovies(){
        return movieRepository.findAll();
    }
}

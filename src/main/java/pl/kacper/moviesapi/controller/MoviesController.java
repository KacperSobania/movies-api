package pl.kacper.moviesapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kacper.moviesapi.dto.MovieDto;
import pl.kacper.moviesapi.entity.Movie;
import pl.kacper.moviesapi.service.MovieService;

import java.util.List;

import static pl.kacper.moviesapi.mapper.MovieDtoMapper.mapMoviesToMovieDtos;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies-api")
public class MoviesController {

    private final MovieService movieService;

    @GetMapping("/movies/{title}")
    public MovieDto getMovieByTitle(@PathVariable String title){
        return movieService.getMovieByTitle(title);
    }

    @PostMapping("/moviess")
    public Movie addFavouriteMovie(@RequestBody Movie movie){
        return movieService.addFavouriteMovie(movie);
    }

    @GetMapping("/favourite-movies")
    public List<MovieDto> getFavouriteMovies(){
        return mapMoviesToMovieDtos(movieService.getFavouriteMovies());
    }
}

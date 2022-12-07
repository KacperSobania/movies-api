package pl.kacper.moviesapi.mapper;

import pl.kacper.moviesapi.dto.MovieDto;
import pl.kacper.moviesapi.entity.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class MovieDtoMapper {
    public static List<MovieDto> mapMoviesToMovieDtos(List<Movie> movies){
        return movies.stream()
                .map(movie -> new MovieDto(movie.getTitle(), movie.getDescription(), movie.getFilmGenre(), movie.getDirector(), movie.getPoster()))
                .collect(Collectors.toList());
    }
}

package pl.kacper.moviesapi.webclient.movie;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.kacper.moviesapi.dto.MovieDto;
import pl.kacper.moviesapi.webclient.movie.dto.OmdbapiMovieDto;

@Component
public class MovieClient {
    private static final String MOVIE_URL = "http://www.omdbapi.com/";
    private static final String API_KEY = "9d7e5e7a";
    private final RestTemplate restTemplate = new RestTemplate();

    public MovieDto getMovieByTitle(String title){
        OmdbapiMovieDto omdbapiMovieDto = callGetMethod("?apikey={apiKey}&t={title}", OmdbapiMovieDto.class, API_KEY, title);
        return MovieDto.builder()
                .title(omdbapiMovieDto.getTitle())
                .description(omdbapiMovieDto.getPlot())
                .filmGenre(omdbapiMovieDto.getGenre())
                .director(omdbapiMovieDto.getDirector())
                .poster(omdbapiMovieDto.getPoster())
                .build();
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object...objects){
        return restTemplate.getForObject(MOVIE_URL + url, responseType, objects);
    }
}

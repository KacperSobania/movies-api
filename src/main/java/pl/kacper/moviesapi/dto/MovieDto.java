package pl.kacper.moviesapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class MovieDto {
    private final String title;
    private final String description;
    private final String filmGenre;
    private final String director;
    private final String poster;
}

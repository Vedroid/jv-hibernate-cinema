package ua.vedroid.cinema.service.mapper;

import ua.vedroid.cinema.model.MovieSession;
import ua.vedroid.cinema.model.dto.MovieSessionRequestDto;
import ua.vedroid.cinema.model.dto.MovieSessionResponseDto;

public interface MovieSessionMapper extends DtoMapper<MovieSession,
        MovieSessionRequestDto, MovieSessionResponseDto> {
}
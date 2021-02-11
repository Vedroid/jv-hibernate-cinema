package ua.vedroid.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vedroid.cinema.model.dto.CinemaHallRequestDto;
import ua.vedroid.cinema.model.dto.CinemaHallResponseDto;
import ua.vedroid.cinema.service.CinemaHallService;
import ua.vedroid.cinema.service.mapper.CinemaHallMapper;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService service;
    private final CinemaHallMapper mapper;

    @Autowired
    public CinemaHallController(CinemaHallService service, CinemaHallMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public void add(@RequestBody CinemaHallRequestDto cinemaHallDto) {
        service.add(mapper.toEntity(cinemaHallDto));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return service.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}

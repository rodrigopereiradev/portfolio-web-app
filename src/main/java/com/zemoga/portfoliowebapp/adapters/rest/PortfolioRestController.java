package com.zemoga.portfoliowebapp.adapters.rest;

import com.zemoga.portfoliowebapp.adapters.dtos.PortfolioResponseDTO;
import com.zemoga.portfoliowebapp.adapters.dtos.PortfolioRequestDTO;
import com.zemoga.portfoliowebapp.adapters.mappers.PortfolioMapper;
import com.zemoga.portfoliowebapp.domain.usecases.IPortfolioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/portfolios")
@RequiredArgsConstructor
public class PortfolioRestController {

    private final PortfolioMapper mapper;
    private final IPortfolioUseCase useCase;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PortfolioResponseDTO> findById(@PathVariable Integer id) {
        var portfolio = useCase.findById(id);
        var portfolioDTO = mapper.toDTO(portfolio);
        return ResponseEntity.ok(portfolioDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody PortfolioRequestDTO portfolioRequestDTO, @PathVariable Integer id) {
        portfolioRequestDTO.setId(id);
        var portfolio = mapper.fromDTO(portfolioRequestDTO);
        useCase.update(portfolio);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PortfolioResponseDTO>> findAll() {
        var portfolios = useCase.findAll();
        return ResponseEntity.ok(portfolios.stream().map(mapper::toDTO).collect(Collectors.toList()));
    }

}

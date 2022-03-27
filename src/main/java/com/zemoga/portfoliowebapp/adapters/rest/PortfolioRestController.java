package com.zemoga.portfoliowebapp.adapters.rest;

import com.zemoga.portfoliowebapp.adapters.dtos.PortfolioDTO;
import com.zemoga.portfoliowebapp.adapters.mappers.PortfolioMapper;
import com.zemoga.portfoliowebapp.domain.usecases.IPortfolioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/portfolios")
@RequiredArgsConstructor
public class PortfolioRestController {

    private final PortfolioMapper mapper;
    private final IPortfolioUseCase useCase;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PortfolioDTO> findById(@PathVariable Integer id) {
        var portfolio = useCase.findById(id);
        var portfolioDTO = mapper.toDTO(portfolio);
        return ResponseEntity.ok(portfolioDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody PortfolioDTO portfolioDTO, @PathVariable Integer id) {
        portfolioDTO.setId(id);
        var portfolio = mapper.fromDTO(portfolioDTO);
        useCase.update(portfolio);

        return ResponseEntity.ok().build();

    }

}

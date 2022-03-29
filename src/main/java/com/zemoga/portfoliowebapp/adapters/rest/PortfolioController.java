package com.zemoga.portfoliowebapp.adapters.rest;

import com.zemoga.portfoliowebapp.adapters.mappers.PortfolioMapper;
import com.zemoga.portfoliowebapp.domain.usecases.IPortfolioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioMapper mapper;
    private final IPortfolioUseCase useCase;

    @GetMapping(value = "/portfolio/{id}")
    public String findPortfolio(Model model, @PathVariable Integer id) {
        var portfolio = useCase.findById(116);
        var dto = mapper.toDTO(portfolio);
        model.addAttribute("portfolio", dto);
        return "portfolio";
    }
}

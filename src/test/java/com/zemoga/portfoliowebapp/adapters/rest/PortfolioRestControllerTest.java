package com.zemoga.portfoliowebapp.adapters.rest;

import com.zemoga.portfoliowebapp.adapters.dtos.PortfolioRequestDTO;
import com.zemoga.portfoliowebapp.adapters.dtos.PortfolioResponseDTO;
import com.zemoga.portfoliowebapp.adapters.mappers.PortfolioMapper;
import com.zemoga.portfoliowebapp.adapters.rest.handlers.GlobalControllerExceptionHandler;
import com.zemoga.portfoliowebapp.domain.models.Portfolio;
import com.zemoga.portfoliowebapp.domain.models.Twitter;
import com.zemoga.portfoliowebapp.domain.usecases.IPortfolioUseCase;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Collections;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PortfolioRestControllerTest {

    @Mock
    private PortfolioMapper mapper;

    @Mock
    private IPortfolioUseCase useCase;

    @InjectMocks
    private PortfolioRestController controller;

    @InjectMocks
    private GlobalControllerExceptionHandler exceptionHandler;


    @BeforeEach
    void setUp() {
        standaloneSetup(controller, exceptionHandler);
    }

    @Test
    void shouldReturnStatusOkAndFieldsFilledWhenFindingPortfolioById() {

        var portfolio = createPortfolio();
        var dto = createPortfolioDTO();

        when(useCase.findById(1)).thenReturn(portfolio);
        when(mapper.toDTO(portfolio)).thenReturn(dto);

        given().get("/api/v1/portfolios/1")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("id", equalTo(1))
                .body("name", equalTo("Teste"))
                .body("lastName", equalTo("Teste"))
                .body("description", equalTo("Teste"))
                .body("experience", equalTo("Teste"))
                .body("imageUrl", equalTo("Teste"))
                .body("twitters", hasSize(1));

    }

    @Test
    void shouldReturnStatusOkWhenUpdatingPortfolio() {

        var portfolio = PortfolioRequestDTO.builder().id(1).name("Teste").lastName("Teste").build();

        given().body(portfolio).contentType("application/json")
                .when()
                .put("/api/v1/portfolios/1")
                .then()
                .statusCode(HttpStatus.OK.value());

    }

    @Test
    void shouldReturnBadRequestWhenUpdatingPortfolioWithNamesNull() {

        var portfolio = PortfolioRequestDTO.builder().id(1).name(null).lastName(null).build();

        given().body(portfolio).contentType("application/json")
                .when()
                .put("/api/v1/portfolios/1")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("descriptions", hasItem("Field name is mandatory."))
                .body("descriptions", hasItem("Field lastName is mandatory."));

    }

    @Test
    void shouldReturnBadRequestWhenUpdatingPortfolioWithNamesEmpty() {

        var portfolio = PortfolioRequestDTO.builder().id(1).name("").lastName("").build();

        given().body(portfolio).contentType("application/json")
                .when()
                .put("/api/v1/portfolios/1")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("descriptions", hasItem("Field name is mandatory."))
                .body("descriptions", hasItem("Field lastName is mandatory."));

    }

    @Test
    void shouldReturnBadRequestWhenUpdatingPortfolioWithFieldsOverSized() {

        var s = getStringOverSized();

        var portfolio = PortfolioRequestDTO.builder()
                .id(1)
                .name(s)
                .lastName(s)
                .description(s)
                .experience(s)
                .imageUrl(s)
                .build();

        given().body(portfolio).contentType("application/json")
                .when()
                .put("/api/v1/portfolios/1")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("descriptions", hasItem("The field experience can not have more than 255 characters."))
                .body("descriptions", hasItem("The field imageUrl can not have more than 255 characters."))
                .body("descriptions", hasItem("The field lastName can not have more than 255 characters."))
                .body("descriptions", hasItem("The field name can not have more than 255 characters."))
                .body("descriptions", hasItem("The field description can not have more than 255 characters."));

    }

    @Test
    void shouldReturnStatusOkWithAtLeastOnePortfolio() {

        var portfolio = Portfolio.builder().build();
        var dto = PortfolioResponseDTO.builder().build();
        when(useCase.findAll()).thenReturn(Collections.singletonList(portfolio));
        when(mapper.toDTO(portfolio)).thenReturn(dto);

        given().get("/api/v1/portfolios")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("results", hasSize(1));
    }

    private PortfolioResponseDTO createPortfolioDTO() {
        return PortfolioResponseDTO.builder()
                .id(1)
                .name("Teste")
                .lastName("Teste")
                .description("Teste")
                .experience("Teste")
                .imageUrl("Teste")
                .twitters(Collections.singletonList(Twitter.builder()
                        .build()))
                .build();
    }

    private Portfolio createPortfolio() {
        return Portfolio.builder()
                .id(1)
                .name("Teste")
                .lastName("Teste")
                .description("Teste")
                .experience("Teste")
                .imageUrl("Teste")
                .twitters(Collections.singletonList(Twitter.builder()
                        .build()))
                .build();
    }

    private String getStringOverSized() {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus semper consequat dolor vel tempor. " +
                "Nulla facilisi. Sed non erat at est eleifend mollis. Phasellus id gravida enim, vel egestas leo. " +
                "Sed facilisis urna est, et rhoncus massa luctus luctus. Aliquam lorem ligula, luctus id magna a.";
    }
}

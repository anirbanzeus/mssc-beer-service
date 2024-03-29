package learn.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import learn.springframework.msscbeerservice.bootstrap.BeerLoader;
import learn.springframework.msscbeerservice.domain.Beer;
import learn.springframework.msscbeerservice.services.BeerService;
import learn.springframework.msscbeerservice.web.model.BeerDto;
import learn.springframework.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @Test
    void getBeerById() throws Exception{

        given(beerService.getBeerById(any())).willReturn(getValidBeerDto());

        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception{

        BeerDto beerDto = getValidBeerDto();
        String beerJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception{

        BeerDto beerDto = getValidBeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());
    }

    public BeerDto getValidBeerDto(){
        return BeerDto.builder()
                .beerName("My Test Beer")
                .beerStyle(BeerStyleEnum.LAGER)
                .price(new BigDecimal("2.980"))
                .quantityOnHand(100)
                .upc(BeerLoader.BEER_1_UPC)
                .build();
    }
}
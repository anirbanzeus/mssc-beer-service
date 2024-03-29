package learn.springframework.msscbeerservice.services;

import learn.springframework.msscbeerservice.web.model.BeerDto;
import org.springframework.http.ResponseEntity;


import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeer(UUID beerId);
}

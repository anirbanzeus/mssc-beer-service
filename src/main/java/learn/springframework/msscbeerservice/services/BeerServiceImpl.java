package learn.springframework.msscbeerservice.services;

import learn.springframework.msscbeerservice.web.model.BeerDto;
import learn.springframework.msscbeerservice.web.model.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService{
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.PALE_ALE)
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {

    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting a beer......");
    }
}

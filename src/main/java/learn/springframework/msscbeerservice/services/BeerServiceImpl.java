package learn.springframework.msscbeerservice.services;

import learn.springframework.msscbeerservice.domain.Beer;
import learn.springframework.msscbeerservice.repositories.BeerRepository;
import learn.springframework.msscbeerservice.web.exception.NotFoundException;
import learn.springframework.msscbeerservice.web.mappers.BeerMapper;
import learn.springframework.msscbeerservice.web.model.BeerDto;
import learn.springframework.msscbeerservice.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService{

    private BeerRepository beerRepository;
    private BeerMapper beerMapper;
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return beerMapper.BeerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.BeerToBeerDto(beerRepository.save(beerMapper.BeerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpcCode(beerDto.getUpc());

        return beerMapper.BeerToBeerDto(beer);
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting a beer......");
    }
}

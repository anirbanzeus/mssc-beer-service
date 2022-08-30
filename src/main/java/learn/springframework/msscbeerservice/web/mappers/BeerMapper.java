package learn.springframework.msscbeerservice.web.mappers;

import learn.springframework.msscbeerservice.domain.Beer;
import learn.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDto dto);

}

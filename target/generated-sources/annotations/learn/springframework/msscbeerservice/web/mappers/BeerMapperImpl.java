package learn.springframework.msscbeerservice.web.mappers;

import javax.annotation.processing.Generated;
import learn.springframework.msscbeerservice.domain.Beer;
import learn.springframework.msscbeerservice.domain.Beer.BeerBuilder;
import learn.springframework.msscbeerservice.web.model.BeerDto;
import learn.springframework.msscbeerservice.web.model.BeerDto.BeerDtoBuilder;
import learn.springframework.msscbeerservice.web.model.BeerStyleEnum;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-10T20:48:25+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
public class BeerMapperImpl implements BeerMapper {

    private final DateMapper dateMapper = new DateMapper();

    @Override
    public BeerDto BeerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDtoBuilder beerDto = BeerDto.builder();

        beerDto.id( beer.getId() );
        beerDto.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDto.lastModifiedDate( dateMapper.asOffsetDateTime( beer.getLastModifiedDate() ) );
        beerDto.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDto.beerStyle( Enum.valueOf( BeerStyleEnum.class, beer.getBeerStyle() ) );
        }
        beerDto.price( beer.getPrice() );

        return beerDto.build();
    }

    @Override
    public Beer BeerToBeerDto(BeerDto dto) {
        if ( dto == null ) {
            return null;
        }

        BeerBuilder beer = Beer.builder();

        beer.id( dto.getId() );
        beer.createdDate( dateMapper.asTimestamp( dto.getCreatedDate() ) );
        beer.lastModifiedDate( dateMapper.asTimestamp( dto.getLastModifiedDate() ) );
        beer.beerName( dto.getBeerName() );
        if ( dto.getBeerStyle() != null ) {
            beer.beerStyle( dto.getBeerStyle().name() );
        }
        beer.price( dto.getPrice() );

        return beer.build();
    }
}

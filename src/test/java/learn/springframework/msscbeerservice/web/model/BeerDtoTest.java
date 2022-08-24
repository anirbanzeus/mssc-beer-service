package learn.springframework.msscbeerservice.web.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Data
class BeerDtoTest {
    BeerDto getBeerDto(){
       return  BeerDto.builder()
                .beerName("Ale")
                .price(new BigDecimal("13.98"))
                .id(UUID.randomUUID())
                .upc(23459L)
               .lastModifiedDate(OffsetDateTime.now())
               .myLocalDate(LocalDate.now())
                .build();
    }

    @Autowired
    ObjectMapper objectMapper;

}
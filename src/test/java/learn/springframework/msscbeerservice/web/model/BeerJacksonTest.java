package learn.springframework.msscbeerservice.web.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@JsonTest
@ActiveProfiles("kebab")
public class BeerJacksonTest extends BeerDtoTest{

    @Test
    public void beerTestJson() throws JsonProcessingException {
        BeerDto beerDto = getBeerDto();
        String data = objectMapper.writeValueAsString(beerDto);
        System.out.println(data);
    }


}

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

    @Test
    public void jsonToBeerDto() throws JsonProcessingException {
        String inputJson = "{\"id\":\"9e21fc73-a020-4d7e-a9e2-f331fc299ebd\",\"created-date\":null,\"last-modified-date\":\"2022-08-24T00:13:10+0530\",\"beer-name\":\"Ale\",\"beer-style\":null,\"upc\":23459,\"price\":\"13.98\",\"quantity-on-hand\":null,\"my-local-date\":\"20220824\"}";
        BeerDto beerDto = objectMapper.readValue(inputJson,BeerDto.class);
        System.out.println(beerDto);
    }


}

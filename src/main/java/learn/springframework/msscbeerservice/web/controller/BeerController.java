package learn.springframework.msscbeerservice.web.controller;

import learn.springframework.msscbeerservice.services.BeerService;
import learn.springframework.msscbeerservice.web.model.BeerDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/beer/")
@RestController
@AllArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@Validated @RequestBody BeerDto beerDto){
        return new ResponseEntity<>(beerService.saveNewBeer(beerDto),HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerId")UUID beerId, @Validated @RequestBody BeerDto beerDto){
        return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto),HttpStatus.NO_CONTENT);
    }
}

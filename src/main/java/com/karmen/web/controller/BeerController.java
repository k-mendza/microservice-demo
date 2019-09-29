package com.karmen.web.controller;

import com.karmen.web.model.BeerDto;
import com.karmen.web.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(BeerController.PATH_URL)
public class BeerController {

    public static final String PATH_URL = "/api/v1/beer";

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping("/postBeer")
    public ResponseEntity<BeerDto> postBeer(BeerDto beerDto) {
        return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED) ;
    }

    @PostMapping("/postBeerWithHeaders")
    public ResponseEntity postBeerWithHeaders(BeerDto beerDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", PATH_URL + beerService.saveNewBeer(beerDto).getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED) ;
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable UUID beerId, BeerDto beerDto){
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}

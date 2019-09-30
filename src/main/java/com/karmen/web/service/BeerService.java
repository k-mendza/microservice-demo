package com.karmen.web.service;

import com.karmen.web.model.BeerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService  {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeer(UUID beerId);
}

package com.karmen.web.service;

import com.karmen.web.model.BeerDto;

import java.util.UUID;

public interface BeerService  {
    BeerDto getBeerById(UUID beerId);
}

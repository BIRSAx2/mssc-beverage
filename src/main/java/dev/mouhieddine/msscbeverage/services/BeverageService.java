package dev.mouhieddine.msscbeverage.services;

import dev.mouhieddine.msscbeverage.web.model.BeverageDto;

import java.util.UUID;

/**
 * @author : Mouhieddine.dev
 * @since : 1/31/2021, Sunday
 **/
public interface BeverageService {
  BeverageDto getBeverageById(UUID id);

  BeverageDto save(BeverageDto beverageDto);

  void updateBeverage(UUID id, BeverageDto beverageDto);
}

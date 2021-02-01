package dev.mouhieddine.msscdrinks.services;

import dev.mouhieddine.msscdrinks.web.model.DrinkDto;

import java.util.UUID;

/**
 * @author : Mouhieddine.dev
 * @since : 1/31/2021, Sunday
 **/
public interface DrinkService {
  DrinkDto getDrinkById(UUID id);

  DrinkDto save(DrinkDto drinkDto);

  void updateDrink(UUID id, DrinkDto drinkDto);

  void deleteById(UUID id);
}

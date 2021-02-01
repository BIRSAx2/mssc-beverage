package dev.mouhieddine.msscdrinks.services;

import dev.mouhieddine.msscdrinks.web.model.DrinkDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author : Mouhieddine.dev
 * @since : 1/31/2021, Sunday
 **/
@Service
@Slf4j
public class DrinkServiceImpl implements DrinkService {

//  BeverageRepository beverageRepository;

  @Override
  public DrinkDto getDrinkById(UUID id) {
    return DrinkDto.builder()
            .id(UUID.randomUUID())
            .name("Lemon Soda")
            .type("Soda")
            .build();
  }

  @Override
  public DrinkDto save(DrinkDto drinkDto) {
    return DrinkDto.builder()
            .id(UUID.randomUUID())
            .build();
  }

  @Override
  public void updateDrink(UUID id, DrinkDto drinkDto) {
    // todo: implement
  }

  @Override
  public void deleteById(UUID id) {
    // todo: implement
  }
}

package dev.mouhieddine.msscbeverage.services;

import dev.mouhieddine.msscbeverage.web.model.BeverageDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author : Mouhieddine.dev
 * @since : 1/31/2021, Sunday
 **/
@Service
public class BeverageServiceImpl implements BeverageService {

//  BeverageRepository beverageRepository;

  @Override
  public BeverageDto getBeverageById(UUID id) {
    return BeverageDto.builder()
            .id(UUID.randomUUID())
            .name("Lemon Soda")
            .type("Soda")
            .build();
  }

  @Override
  public BeverageDto save(BeverageDto beverageDto) {
    return BeverageDto.builder()
            .id(UUID.randomUUID())
            .build();
  }

  @Override
  public void updateBeverage(UUID id, BeverageDto beverageDto) {
    //to do implement
  }
}

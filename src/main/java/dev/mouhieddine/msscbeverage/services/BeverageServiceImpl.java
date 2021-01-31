package dev.mouhieddine.msscbeverage.services;

import dev.mouhieddine.msscbeverage.web.model.BeverageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author : Mouhieddine.dev
 * @since : 1/31/2021, Sunday
 **/
@Service
@Slf4j
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
    // todo: implement
  }

  @Override
  public void deleteById(UUID id) {
    // todo: implement
  }
}

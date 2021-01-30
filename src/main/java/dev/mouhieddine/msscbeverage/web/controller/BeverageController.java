package dev.mouhieddine.msscbeverage.web.controller;

import dev.mouhieddine.msscbeverage.web.model.BeverageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author : Mouhieddine.dev
 * @since : 1/30/2021, Saturday
 **/
@RestController
@RequestMapping(BeverageController.BASE_URL)
public class BeverageController {
  public final static String BASE_URL = "/api/v1/beverage";

  @GetMapping("/{id}")
  public ResponseEntity<BeverageDto> getBeverage(UUID id) {
  return new ResponseEntity<>(BeverageDto.builder().build(), HttpStatus.OK);
  }
}

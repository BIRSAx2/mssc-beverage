package dev.mouhieddine.msscbeverage.web.controller;

import dev.mouhieddine.msscbeverage.services.BeverageService;
import dev.mouhieddine.msscbeverage.web.model.BeverageDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author : Mouhieddine.dev
 * @since : 1/30/2021, Saturday
 **/
@RestController
@RequestMapping(BeverageController.BASE_URL)
public class BeverageController {
  public final static String BASE_URL = "/api/v1/beverage";

  private final BeverageService beverageService;

  public BeverageController(BeverageService beverageService) {
    this.beverageService = beverageService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<BeverageDto> getBeverage(@PathVariable UUID id) {
    return new ResponseEntity<>(beverageService.getBeverageById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<HttpHeaders> createBeverage(@RequestBody BeverageDto beverageDto) {
    BeverageDto savedDto = beverageService.save(beverageDto);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", BASE_URL + "/" + savedDto.getId().toString());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping({"/{id}"})
  public ResponseEntity<HttpStatus> updateBeverage(@PathVariable UUID id, @RequestBody BeverageDto beverageDto) {
    beverageService.updateBeverage(id, beverageDto);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}

package dev.mouhieddine.msscdrinks.web.controller;

import dev.mouhieddine.msscdrinks.services.DrinkService;
import dev.mouhieddine.msscdrinks.web.model.DrinkDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @author : Mouhieddine.dev
 * @since : 1/30/2021, Saturday
 **/
@RestController
@RequestMapping(DrinkController.BASE_URL)
public class DrinkController {
  public final static String BASE_URL = "/api/v1/drink";

  private final DrinkService drinkService;

  public DrinkController(DrinkService drinkService) {
    this.drinkService = drinkService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<DrinkDto> getDrink(@PathVariable UUID id) {
    return new ResponseEntity<>(drinkService.getDrinkById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<HttpHeaders> createDrink(@Valid @RequestBody DrinkDto drinkDto) {
    DrinkDto savedDto = drinkService.save(drinkDto);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", BASE_URL + "/" + savedDto.getId().toString());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping({"/{id}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)

  public void updateDrink(@PathVariable UUID id, @Valid @RequestBody DrinkDto drinkDto) {
    drinkService.updateDrink(id, drinkDto);
  }

  @DeleteMapping({"/{id}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteDrink(@PathVariable UUID id) {
    drinkService.deleteById(id);
  }
}

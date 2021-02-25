package dev.mouhieddine.msscdrinks.web.controller;

import dev.mouhieddine.msscdrinks.services.DrinkService;
import dev.mouhieddine.msscdrinks.web.model.DrinkDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author : Mouhieddine.dev
 * @since : 1/30/2021, Saturday
 **/
@Validated
@RestController
@RequestMapping(DrinkController.BASE_URL)
public class DrinkController {
  public final static String BASE_URL = "/api/v1/drink";

  private final DrinkService drinkService;

  public DrinkController(DrinkService drinkService) {
    this.drinkService = drinkService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<DrinkDto> getDrink(@NotNull @PathVariable UUID id) {
    return new ResponseEntity<>(drinkService.getDrinkById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<HttpHeaders> createDrink(@NotNull @Valid @RequestBody DrinkDto drinkDto) {
    DrinkDto savedDto = drinkService.save(drinkDto);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", BASE_URL + "/" + savedDto.getId().toString());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping({"/{id}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateDrink(@NotNull @PathVariable UUID id, @NotNull @Valid @RequestBody DrinkDto drinkDto) {
    drinkService.updateDrink(id, drinkDto);
  }

  @DeleteMapping({"/{id}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteDrink(@NotNull @PathVariable UUID id) {
    drinkService.deleteById(id);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {
    List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

    e.getConstraintViolations().forEach(constraintViolation -> {
      errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
    });

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }
}

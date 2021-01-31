package dev.mouhieddine.msscbeverage.web.controller;

import dev.mouhieddine.msscbeverage.services.CustomerService;
import dev.mouhieddine.msscbeverage.web.model.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author : Mouhieddine.dev
 * @since : 1/31/2021, Sunday
 **/
@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {
  public final static String BASE_URL = "/api/v1/customer";

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }


  @GetMapping({"/{id}"})
  public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID id) {
    return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
  }
}

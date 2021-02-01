package dev.mouhieddine.msscdrinks.web.controller;

import dev.mouhieddine.msscdrinks.services.CustomerService;
import dev.mouhieddine.msscdrinks.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
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

  @PostMapping
  public ResponseEntity<HttpHeaders> createCustomer(@RequestBody CustomerDto customerDto) {
    CustomerDto savedCustomer = customerService.save(customerDto);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", CustomerController.BASE_URL + "/" + savedCustomer.getId());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping({"/{id}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateCustomer(@PathVariable UUID id, @RequestBody CustomerDto customerDto) {
    customerService.updateCustomer(id, customerDto);
  }

  @DeleteMapping({"/{id}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCustomer(@PathVariable UUID id) {
    customerService.deleteById(id);
  }
}

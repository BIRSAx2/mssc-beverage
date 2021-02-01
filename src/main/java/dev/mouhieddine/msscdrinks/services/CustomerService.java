package dev.mouhieddine.msscdrinks.services;

import dev.mouhieddine.msscdrinks.web.model.CustomerDto;

import java.util.UUID;

/**
 * @author : Mouhieddine.dev
 * @since : 1/31/2021, Sunday
 **/
public interface CustomerService {
  CustomerDto getCustomerById(UUID id);

  CustomerDto save(CustomerDto customerDto);

  void updateCustomer(UUID id, CustomerDto customerDto);

  void deleteById(UUID id);
}

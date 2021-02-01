package dev.mouhieddine.msscdrinks.services;

import dev.mouhieddine.msscdrinks.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author : Mouhieddine.dev
 * @since : 1/31/2021, Sunday
 **/

@Service
public class CustomerServiceImpl implements CustomerService {
  @Override
  public CustomerDto getCustomerById(UUID id) {
    return CustomerDto.builder()
            .id(UUID.randomUUID())
            .name("Portgas D. Ace")
            .build();
  }

  @Override
  public CustomerDto save(CustomerDto customerDto) {
    return CustomerDto.builder()
            .id(UUID.randomUUID())
            .build();
  }

  @Override
  public void updateCustomer(UUID id, CustomerDto customerDto) {
    // todo: implement
  }

  @Override
  public void deleteById(UUID id) {
    // todo: implement
  }
}

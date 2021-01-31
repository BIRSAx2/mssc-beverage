package dev.mouhieddine.msscbeverage.services;

import dev.mouhieddine.msscbeverage.web.model.CustomerDto;
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
}

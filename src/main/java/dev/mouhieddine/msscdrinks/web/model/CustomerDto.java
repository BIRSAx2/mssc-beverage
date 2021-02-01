package dev.mouhieddine.msscdrinks.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author : Mouhieddine.dev
 * @since : 1/31/2021, Sunday
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
  private UUID id;
  private String name;
}

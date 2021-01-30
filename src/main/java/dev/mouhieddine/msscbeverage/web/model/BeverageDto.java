package dev.mouhieddine.msscbeverage.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author : Mouhieddine.dev
 * @since : 1/30/2021, Saturday
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeverageDto {

  private UUID id;
  private String name;
  private String type;
  private Long upc;
}

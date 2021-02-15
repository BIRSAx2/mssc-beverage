package dev.mouhieddine.msscdrinks.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.UUID;

/**
 * @author : Mouhieddine.dev
 * @since : 1/30/2021, Saturday
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DrinkDto {
  @Null
  private UUID id;
  @NotBlank
  private String name;
  @NotBlank
  private String type;
  @Positive
  private Long upc;
}

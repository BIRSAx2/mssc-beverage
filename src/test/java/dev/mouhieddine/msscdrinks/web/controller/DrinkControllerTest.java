package dev.mouhieddine.msscdrinks.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.mouhieddine.msscdrinks.services.DrinkService;
import dev.mouhieddine.msscdrinks.web.model.DrinkDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author : Mouhieddine.dev
 * @since : 2/15/2021, Monday
 **/
@ExtendWith(SpringExtension.class)
@WebMvcTest(DrinkController.class)
public class DrinkControllerTest {

  @MockBean
  DrinkService drinkService;

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  DrinkDto validDrink;

  @BeforeEach
  public void setUp() {
    validDrink = DrinkDto.builder().id(UUID.randomUUID())
            .name("Lemon Soda")
            .type("Soda")
            .upc(123456789012L)
            .build();
  }

  @Test
  public void getDrinkById() throws Exception {
    given(drinkService.getDrinkById(any(UUID.class))).willReturn(validDrink);

    mockMvc.perform(get(DrinkController.BASE_URL + "/" + validDrink.getId().toString()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id", is(validDrink.getId().toString())))
            .andExpect(jsonPath("$.name", is(validDrink.getName())));
  }

  @Test
  public void createDrink() throws Exception {
    //given
    DrinkDto drinkDto = validDrink;
    drinkDto.setId(null);
    DrinkDto savedDto = DrinkDto.builder().id(UUID.randomUUID()).name("New drink").build();
    String drinkDtoJson = objectMapper.writeValueAsString(drinkDto);

    given(drinkService.save(any())).willReturn(savedDto);

    mockMvc.perform(post(DrinkController.BASE_URL + "/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(drinkDtoJson))
            .andExpect(status().isCreated());

  }

  @Test
  public void updateDrink() throws Exception {
    //given
    DrinkDto drinkDto = validDrink;
    drinkDto.setId(null);
    String drinkDtoJson = objectMapper.writeValueAsString(drinkDto);

    //when
    mockMvc.perform(put(DrinkController.BASE_URL + "/" + UUID.randomUUID())
            .contentType(MediaType.APPLICATION_JSON)
            .content(drinkDtoJson))
            .andExpect(status().isNoContent());

    then(drinkService).should().updateDrink(any(), any());

  }
}
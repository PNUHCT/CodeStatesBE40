package com.codestates.coffee.mapstruct.mapper;

import com.codestates.coffee.CoffeePatchDto;
import com.codestates.coffee.CoffeePostDto;
import com.codestates.coffee.CoffeeResponseDto;
import com.codestates.coffee.entity.Coffee;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CoffeeMapper {
 Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);
 Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);
 CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);
 List<CoffeeResponseDto> coffeeToCoffeeResponseDto(List<Coffee> coffees);
}
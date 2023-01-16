package com.codestates.coffee.mapper;

import com.codestates.coffee.dto.CoffeeDto;
import com.codestates.coffee.dto.CoffeePatchDto;
import com.codestates.coffee.dto.CoffeePostDto;
import com.codestates.coffee.dto.CoffeeResponseDto;
import com.codestates.coffee.entity.Coffee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee coffeePostDtoToCoffee(CoffeeDto.Post requestBody);
    Coffee coffeePatchDtoToCoffee(CoffeeDto.Patch requestBody);
    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);
    List<CoffeeResponseDto> coffeesToCoffeeResponseDtos(List<Coffee> coffees);
}

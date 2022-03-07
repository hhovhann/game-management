package com.hhovhann.gamemanagement.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
public class GeographyDto {

    @NotBlank
    String country;
    @NotBlank
    String city;
}
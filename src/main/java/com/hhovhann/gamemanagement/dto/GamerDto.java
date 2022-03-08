package com.hhovhann.gamemanagement.dto;


import com.hhovhann.gamemanagement.entity.data.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GamerDto {
    private Long id;
    private String name;
    private Level level;
    private String country;
    private String city;
}

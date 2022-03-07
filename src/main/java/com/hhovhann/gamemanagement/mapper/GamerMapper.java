package com.hhovhann.gamemanagement.mapper;

import com.hhovhann.gamemanagement.dto.CreateGamerRequestDto;
import com.hhovhann.gamemanagement.dto.CreateGamerResponseDto;
import com.hhovhann.gamemanagement.dto.SearchGamerRequestDto;
import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;
import com.hhovhann.gamemanagement.entity.Gamer;
import org.springframework.stereotype.Component;

@Component
public class GamerMapper {

    public Gamer toSearchEntity(SearchGamerRequestDto searchGamerRequestDto) {
        // todo add mapping to game entity
        return null;
    }

    public Gamer toCreateEntity(CreateGamerRequestDto createGamerRequestDto) {
        // todo add mapping to game entity
        return null;
    }

    public SearchGamerResponseDto toSearchDto(Gamer gamer) {
        // todo add mapping to game entity
        return null;
    }

    public CreateGamerResponseDto toCreateDto(Gamer gamer) {
        // todo add mapping to game entity
        return null;
    }
}

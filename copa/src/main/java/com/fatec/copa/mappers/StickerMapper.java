package com.fatec.copa.mappers;

import com.fatec.copa.dtos.StickerRequest;
import com.fatec.copa.dtos.StickerResponse;
import com.fatec.copa.entities.Sticker;

public class StickerMapper {

    // Entity para DTO
    public static Sticker toEntity(StickerRequest request) {
        Sticker s = new Sticker();
        s.setName(request.name());
        s.setTeam(request.team());
        s.setType(request.type());
        s.setNumber(request.number());
        s.setDoubles(request.doubles());

        return s;
    }

    // DTO para Entity
    public static StickerResponse toDTO(Sticker sticker) {
        return new StickerResponse(
                sticker.getId(),
                sticker.getName(),
                sticker.getTeam(),
                sticker.getType(),
                sticker.getNumber(),
                sticker.getDoubles());
    }

}

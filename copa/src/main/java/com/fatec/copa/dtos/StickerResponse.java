package com.fatec.copa.dtos;

public record StickerResponse(
        Long id,
        String name,
        String team,
        String type,
        String number,
        Integer doubles) {

}

package com.fatec.copa.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StickerRequest(

        // sem id

        @NotBlank(message = "O nome não pode ser em branco") @Size(min = 2, max = 50, message = "Nome deve ter no minimo 2 e no maximo 50 caracteres") String name,

        @NotBlank(message = "O time/país não pode ser em branco") @Size(min = 4, max = 50, message = "Time/País deve ter no minimo 4 e no maximo 50 caracteres") String team,

        @NotBlank(message = "O tipo não pode ser em branco") @Size(min = 7, max = 20, message = "Tipo deve ter no minimo 7 e no maximo 20 caracteres") String type,

        @NotBlank(message = "O número da figurinha não pode ser em branco") @Size(min = 4, max = 5, message = "Número deve ter no minimo 4 e no maximo 5 caracteres") String number,

        @Min(value = 0, message = "A quantidade de duplicatas não pode ser menor que zero") Integer doubles) {
}

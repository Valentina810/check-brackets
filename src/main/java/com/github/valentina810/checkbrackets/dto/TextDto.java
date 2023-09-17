package com.github.valentina810.checkbrackets.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TextDto {

    @NotBlank(message = "Значение поля не может быть пустым или состоять из пробелов")
    @Schema(description = "Текст для проверки", example = "Текст может содержать или ) не содержать скобки (")
    private String text;
}
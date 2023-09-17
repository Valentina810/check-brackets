package com.github.valentina810.checkbrackets.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCheckBracketsDto {

    @Schema(description = "Результат проверки", example = "true")
    private Boolean isCorrect;
}
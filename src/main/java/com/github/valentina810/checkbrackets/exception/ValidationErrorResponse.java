package com.github.valentina810.checkbrackets.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Schema(description = "Сущность для описания списка ошибок валидации")
public class ValidationErrorResponse {

    @Schema(description = "Список ошибок")
    private final List<Violation> violations;
}
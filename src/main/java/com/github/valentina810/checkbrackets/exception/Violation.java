package com.github.valentina810.checkbrackets.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@Schema(description = "Сущность для описания ошибки валидации")
public class Violation {

    @Schema(description = "Название поля", example = "text")
    private final String fieldName;

    @Schema(description = "Описание ошибки валидации", example = "Значение поля не может быть пустым или состоять из пробелов")
    private final String message;
}
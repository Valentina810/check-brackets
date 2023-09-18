package com.github.valentina810.checkbrackets.controller;

import com.github.valentina810.checkbrackets.dto.CheckBracketsDto;
import com.github.valentina810.checkbrackets.dto.TextDto;
import com.github.valentina810.checkbrackets.service.CheckBracketsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/checkBrackets")
@Tag(name = "Проверка правильности расстановки скобок в тексте")
public class CheckBracketsController {

    private final CheckBracketsService checkBracketsService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Метод проверяет, правильно ли в тексте расставлены скобки, возвращает true - когда скобки расставлены правильно, false - в противном случае")
    public CheckBracketsDto addRequest(@Valid @RequestBody TextDto textDto) {
        return checkBracketsService.checkBrackets(textDto);
    }
}
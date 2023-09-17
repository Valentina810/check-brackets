package com.github.valentina810.checkbrackets.service;

import com.github.valentina810.checkbrackets.dto.ResponseCheckBracketsDto;
import com.github.valentina810.checkbrackets.dto.TextDto;

public interface CheckBracketsService {
    ResponseCheckBracketsDto check(TextDto textDto);

    boolean validateTextBetweenBrackets(String text);
}
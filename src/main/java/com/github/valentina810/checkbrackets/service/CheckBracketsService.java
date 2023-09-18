package com.github.valentina810.checkbrackets.service;

import com.github.valentina810.checkbrackets.dto.CheckBracketsDto;
import com.github.valentina810.checkbrackets.dto.TextDto;

public interface CheckBracketsService {
    CheckBracketsDto checkBrackets(TextDto textDto);

    boolean checkBracketsInText(String text);
}
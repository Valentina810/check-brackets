package com.github.valentina810.checkbrackets.service;

import com.github.valentina810.checkbrackets.dto.ResponseCheckBracketsDto;
import com.github.valentina810.checkbrackets.dto.TextDto;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class CheckBracketsServiceImpl implements CheckBracketsService {

    @Override
    public ResponseCheckBracketsDto check(TextDto textDto) {
        return ResponseCheckBracketsDto.builder()
                .isCorrect(validateTextBetweenBrackets(textDto.getText())).build();
    }

    public boolean validateTextBetweenBrackets(String input) {
        Stack<Character> stack = new Stack<>();
        boolean hasText = false;
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                hasText = false;
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || !hasText) {
                    return false;
                } else {
                    char top = stack.pop();
                    if ((c == ')' && top != '(') ||
                            (c == '}' && top != '{') ||
                            (c == ']' && top != '[')) {
                        return false;
                    }
                }
            } else {
                if ((c != ' ') || hasText) {
                    hasText = true;
                }
            }
        }
        return stack.isEmpty();
    }
}
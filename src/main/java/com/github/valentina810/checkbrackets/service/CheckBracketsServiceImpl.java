package com.github.valentina810.checkbrackets.service;

import com.github.valentina810.checkbrackets.dto.CheckBracketsDto;
import com.github.valentina810.checkbrackets.dto.TextDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Deque;

@Service
@Slf4j
public class CheckBracketsServiceImpl implements CheckBracketsService {

    public CheckBracketsDto checkBrackets(TextDto textDto) {
        boolean isCorrect = checkBracketsInText(textDto.getText());
        log.info("Для текста объекта {} получен ответ {}", textDto, isCorrect);
        return CheckBracketsDto.builder()
                .isCorrect(isCorrect).build();
    }

    public boolean checkBracketsInText(String text) {
        Deque<Character> stack = new ArrayDeque<>();
        boolean hasText = false;

        for (char c : text.toCharArray()) {
            if (isOpeningBracket(c)) {
                stack.push(c);
                hasText = false;
            } else if (isClosingBracket(c)) {
                if (stack.isEmpty() || !hasText || !isValidPair(stack.pop(), c)) {
                    return false;
                }
            } else {
                if (!Character.isWhitespace(c) || hasText) {
                    hasText = true;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpeningBracket(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isClosingBracket(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    private boolean isValidPair(char openBracket, char closeBracket) {
        return (closeBracket == ')' && openBracket == '(') ||
                (closeBracket == '}' && openBracket == '{') ||
                (closeBracket == ']' && openBracket == '[');
    }
}
package com.github.valentina810.checkbrackets.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
public class CheckBracketsServiceImplTest {

    @InjectMocks
    private CheckBracketsServiceImpl checkBracketsService;

    @ParameterizedTest
    @MethodSource("com.github.valentina810.checkbrackets.service.parameters.CheckBracketsServiceImplTestProvider#checkText_whenValidBrackets_thenReturnTrue")
    public void checkText_whenValidBrackets_thenReturnTrue(String parameter) {
        assertTrue(checkBracketsService.checkBracketsInText(parameter));
    }

    @ParameterizedTest
    @MethodSource("com.github.valentina810.checkbrackets.service.parameters.CheckBracketsServiceImplTestProvider#checkText_whenTextWithoutBrackets_thenReturnTrue")
    public void checkText_whenTextWithoutBrackets_thenReturnTrue(String parameter) {
        assertTrue(checkBracketsService.checkBracketsInText(parameter));
    }

    @ParameterizedTest
    @MethodSource("com.github.valentina810.checkbrackets.service.parameters.CheckBracketsServiceImplTestProvider#checkText_whenInvalidBrackets_thenReturnFalse")
    public void checkText_whenInvalidBrackets_thenReturnFalse(String parameter) {
        assertFalse(checkBracketsService.checkBracketsInText(parameter));
    }

    @ParameterizedTest
    @MethodSource("com.github.valentina810.checkbrackets.service.parameters.CheckBracketsServiceImplTestProvider#checkText_whenEmptyTextInBrackets_thenReturnFalse")
    public void checkText_whenEmptyTextInBrackets_thenReturnFalse(String parameter) {
        assertFalse(checkBracketsService.checkBracketsInText(parameter));
    }
}

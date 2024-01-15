package com.github.valentina810.checkbrackets.controller.parameters;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CheckBracketsControllerTestProvider {
    static Stream<Arguments> provider() {
        return Stream.of(Arguments.of(ParameterForCheckBracketsControllerTest.builder()
                        .testName("checkText_whenEmptyText_thenReturnResponseBadRequest")
                        .text("")
                        .build()),
                Arguments.of(ParameterForCheckBracketsControllerTest.builder()
                        .testName("checkText_whenSpaceText_thenReturnResponseBadRequest")
                        .text("    ")
                        .build())
        );
    }
}
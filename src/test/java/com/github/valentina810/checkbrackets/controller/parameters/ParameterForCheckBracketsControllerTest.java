package com.github.valentina810.checkbrackets.controller.parameters;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class ParameterForCheckBracketsControllerTest {
    private String testName;
    private String text;
}
package com.github.valentina810.checkbrackets.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.valentina810.checkbrackets.dto.CheckBracketsDto;
import com.github.valentina810.checkbrackets.dto.TextDto;
import com.github.valentina810.checkbrackets.exception.ObjectMapperException;
import com.github.valentina810.checkbrackets.exception.Violation;
import com.github.valentina810.checkbrackets.service.CheckBracketsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CheckBracketsController.class)
class CheckBracketsControllerTest {

    @MockBean
    private CheckBracketsService checkBracketsService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    private final Violation VIOLATION_TEXT = Violation.builder()
            .fieldName("text")
            .message("Значение поля не может быть пустым или состоять из пробелов")
            .build();

    private final CheckBracketsDto checkBracketsDto = CheckBracketsDto
            .builder()
            .isCorrect(true)
            .build();

    private final TextDto correctTextDto = TextDto
            .builder()
            .text("text()")
            .build();

    private final TextDto emptyTextDto = TextDto
            .builder()
            .text("")
            .build();

    private final TextDto spaceTextDto = TextDto
            .builder()
            .text("    ")
            .build();

    @Test
    void checkText_whenValidText_thenReturnResponseCheckBracketsDto() {
        when(checkBracketsService.checkBrackets(any()))
                .thenReturn(checkBracketsDto);

        try {
            mvc.perform(post("/api/checkBrackets")
                            .content(mapper.writeValueAsString(correctTextDto))
                            .characterEncoding(StandardCharsets.UTF_8)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.isCorrect", is(checkBracketsDto.getIsCorrect()), Boolean.class));
        } catch (Exception e) {
            throw new ObjectMapperException(correctTextDto);
        }

        verify(checkBracketsService, times(1)).checkBrackets(correctTextDto);
    }

    @Test
    void checkText_whenEmptyText_thenReturnResponseBadRequest() {
        try {
            mvc.perform(post("/api/checkBrackets")
                            .content(mapper.writeValueAsString(emptyTextDto))
                            .characterEncoding(StandardCharsets.UTF_8)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.violations.[0].fieldName", is(VIOLATION_TEXT.getFieldName()), String.class))
                    .andExpect(jsonPath("$.violations.[0].message", is(VIOLATION_TEXT.getMessage()), String.class));
        } catch (Exception e) {
            throw new ObjectMapperException(emptyTextDto);
        }

        verify(checkBracketsService, never()).checkBrackets(emptyTextDto);
    }

    @Test
    void checkText_whenSpaceText_thenReturnResponseBadRequest() {
        try {

            mvc.perform(post("/api/checkBrackets")
                            .content(mapper.writeValueAsString(spaceTextDto))
                            .characterEncoding(StandardCharsets.UTF_8)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.violations.[0].fieldName", is(VIOLATION_TEXT.getFieldName()), String.class))
                    .andExpect(jsonPath("$.violations.[0].message", is(VIOLATION_TEXT.getMessage()), String.class));
        } catch (Exception e) {
            throw new ObjectMapperException(spaceTextDto);
        }

        verify(checkBracketsService, never()).checkBrackets(spaceTextDto);
    }
}
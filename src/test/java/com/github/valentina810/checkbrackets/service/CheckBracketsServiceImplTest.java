package com.github.valentina810.checkbrackets.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
public class CheckBracketsServiceImplTest {

    @InjectMocks
    private CheckBracketsServiceImpl checkBracketsService;

    @Test
    public void checkText_whenValidBrackets_thenReturnTrue() {
        assertAll(
                "Проверка возврата true при корректных скобках",

                () -> assertTrue(checkBracketsService.validateTextBetweenBrackets("Привет (мир)")),

                () -> assertTrue(checkBracketsService.validateTextBetweenBrackets("Текст из нескольких слов [несколько слов]")),

                () -> assertTrue(checkBracketsService.validateTextBetweenBrackets("Разные {[(скобки)]}")),

                () -> assertTrue(checkBracketsService.validateTextBetweenBrackets("Текст ( текст в скобках ) с пробелами")),

                () -> assertTrue(checkBracketsService.validateTextBetweenBrackets("Тоже текст (в (скобках) с пробелами)")),

                () -> assertTrue(checkBracketsService.validateTextBetweenBrackets("Несколько повторений {скобки (с)} текстом, (и еще одни[сноска])")),

                () -> assertTrue(checkBracketsService.validateTextBetweenBrackets("Вчера я отправился в поход в лес (это мое любимое место для отдыха) вместе с друзьями. Мы выбрали маршрут, который проходил через горные потоки и поля (для разнообразия). В начале пути погода была отличной, солнце светило ярко, и птицы радостно пели. Однако, когда мы подошли ближе к вершине горы, небо стало покрываться облаками, (как будто природа готовила нам небольшой сюрприз). Несмотря на это, виды были захватывающими, особенно когда мы достигли высшей точки и увидели прекрасный вид на долину (я почувствовал, что все усилия стоили того)."))
        );
    }

    @Test
    public void checkText_whenTextWithoutBrackets_thenReturnTrue() {
        assertAll(
                "Проверка возврата true в случае текста без скобок",

                () -> assertTrue(checkBracketsService.validateTextBetweenBrackets("")),

                () -> assertTrue(checkBracketsService.validateTextBetweenBrackets("Нет скобок")),

                () -> assertTrue(checkBracketsService.validateTextBetweenBrackets("Вчера я отправился в поход в лес это мое любимое место для отдыха вместе с друзьями. Мы выбрали маршрут, который проходил через горные потоки и поля для разнообразия. В начале пути погода была отличной, солнце светило ярко, и птицы радостно пели. Однако, когда мы подошли ближе к вершине горы, небо стало покрываться облаками, как будто природа готовила нам небольшой сюрприз. Несмотря на это, виды были захватывающими, особенно когда мы достигли высшей точки и увидели прекрасный вид на долину я почувствовал, что все усилия стоили того."))
        );
    }

    @Test
    public void checkText_whenInvalidBrackets_thenReturnFalse() {
        assertAll(
                "Проверка возврата false в случае текста c некорректными скобками",

                () -> assertFalse(checkBracketsService.validateTextBetweenBrackets("Не закрытая ] скобка")),

                () -> assertFalse(checkBracketsService.validateTextBetweenBrackets("Закрытая ( но } не совпадающая скобка")),

                () -> assertFalse(checkBracketsService.validateTextBetweenBrackets("Закрытая ( скобка без пары")),

                () -> assertFalse(checkBracketsService.validateTextBetweenBrackets("Открытая ) скобка без пары")),

                () -> assertFalse(checkBracketsService.validateTextBetweenBrackets("Скобка ( не закрытая ) но ) есть парные скобки ")),

                () -> assertFalse(checkBracketsService.validateTextBetweenBrackets("Скобка [ не ] закрытая ] но есть парные скобки")),

                () -> assertFalse(checkBracketsService.validateTextBetweenBrackets("Скобки [ парные ] но нарушен порядок ] этих [ скобок")),

                () -> assertFalse(checkBracketsService.validateTextBetweenBrackets("Скобки [ парные { но нарушен (порядок ) этих ] скобок}"))
        );
    }

    @Test
    public void checkText_whenEmptyTextInBrackets_thenReturnFalse() {
        assertAll(
                "Проверка возврата false в случае текста c пустыми скобками",

                () -> assertFalse(checkBracketsService.validateTextBetweenBrackets("Пустые () скобки")),

                () -> assertFalse(checkBracketsService.validateTextBetweenBrackets("(    )")),

                () -> assertFalse(checkBracketsService.validateTextBetweenBrackets("Пустые скобки (      ) с пробелами")),

                () -> assertFalse(checkBracketsService.validateTextBetweenBrackets("Непустые [(скобки)] и пустые ()")),

                () -> assertFalse(checkBracketsService.validateTextBetweenBrackets("Вложенные [(пустые)] скобки ([])")),

                () -> assertFalse(checkBracketsService.validateTextBetweenBrackets("Пустые [(скобки)[] внутри скобок ]"))
        );
    }
}

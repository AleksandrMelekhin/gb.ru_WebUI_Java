package ru.example.fourth;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static ru.example.fourth.FourthHomeWork.triangle;

class TriangleTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Started");
    }
    @ParameterizedTest
    @DisplayName("Позитивная проверка")
    @CsvSource({"6, 5, 6, 7", "6, 6, 7, 8", "8, 7, 8, 9"})
    void positive(int exectedResult, int a, int b, int c) throws TriangleSideException{
        Assertions.assertEquals(exectedResult, triangle(a, b, c));
    }
    @ParameterizedTest
    @DisplayName("Одна из сторон равна 0")
    @CsvSource({"6, 0, 6, 7", "6, 6, 0, 8", "8, 7, 8, 0"})
    void NegativeOneSideIsEqualZero(int exectedResult, int a, int b, int c) throws TriangleSideException{
        Assertions.assertEquals(exectedResult, triangle(a, b, c));
    }
}


package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FelineKittensParameterizedTest {

    static Stream<Arguments> getTestData() {
        return Stream.of(
                arguments(1, 1),
                arguments(5, 5),
                arguments(0, 0),
                arguments(10, 10),
                arguments(-1, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    public void testGetKittensWithCount(int input, int expected) {
        Feline feline = new Feline(); // Здесь достаточно обычного объекта
        int actual = feline.getKittens(input);
        assertEquals(expected, actual, "Количество котят не совпадает");
    }
}
package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatParameterizedTest {

    @Mock
    private Feline feline;

    @ParameterizedTest
    @ValueSource(strings = {"Кошка", "Котенок", "Кот"})
    public void testGetSoundParameterized(String catType) {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound(), "Звук должен быть Мяу для : " + catType);
    }
}
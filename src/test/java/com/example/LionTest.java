package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private FelineInterface feline;

    @Test
    public void testLionConstructorThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion(feline, "Нечто среднее");
        });
        assertEquals("Необходимо использовать допустимые значения пола животного", exception.getMessage());
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getKittens()).thenReturn(3);

        int actualKittens = lion.getKittens();

        assertEquals(3, actualKittens);
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        List<String> food = List.of("Мясо", "Птица");
        Mockito.when(feline.eatMeat()).thenReturn(food);

        List<String> actualFood = lion.getFood();

        assertEquals(food, actualFood);
        Mockito.verify(feline).eatMeat();
    }
}
package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Птица");
        Mockito.doReturn(expectedFood).when(feline).getFood("Хищник");

        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood);
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensNoArgs() {
        assertEquals(1, feline.getKittens());
    }
}
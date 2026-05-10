package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith(MockitoExtension.class)
public class LionManeParameterizedTest {

    @Mock
    private FelineInterface feline;

    static Stream<Arguments> getLionData() {
        return Stream.of(
                arguments("Самец", true),
                arguments("Самка", false)
        );
    }

    @ParameterizedTest
    @MethodSource("getLionData")
    public void testLionMane(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(feline, sex);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
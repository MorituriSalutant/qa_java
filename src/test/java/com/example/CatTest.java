package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void whenCallGetSoundThenReturnString() {
        String expect = "Мяу";

        String actual = cat.getSound();

        assertEquals(expect, actual);
    }

    @Test
    public void whenCallGetFoodThenReturnList() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expect = Arrays.asList("Животные", "Птицы", "Рыба");

        List<String> actual = cat.getFood();

        assertEquals(expect, actual);
    }
}
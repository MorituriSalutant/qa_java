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
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private static Feline feline;

    Lion lion;

    @Before
    public void setUp() throws Exception {
        String gender = "Самец";
        lion = new Lion(feline, gender);
    }

    @Test
    public void whenCallGetKittensThenReturnOne() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expect = 1;

        int actual = lion.getKittens();

        assertEquals(expect, actual);
    }

    @Test
    public void whenCreateClassLionThenReturnException() {
        Exception exception = null;
        String expect = "Используйте допустимые значения пола животного - самец или самка";
        String actual = null;

        try {
            lion = new Lion(feline,"Табуретка");
        } catch (Exception ex) {
            exception = ex;
            actual = exception.getMessage();
        }

        assertNotNull(exception);
        assertEquals(expect, actual);
    }

    @Test
    public void whenCallGetFoodThenReturnList() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expect = Arrays.asList("Животные", "Птицы", "Рыба");

        List<String> actual = lion.getFood();

        assertEquals(expect, actual);
    }
}
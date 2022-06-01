package com.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class LionTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private static Feline feline;

    Lion lion;

    @Test
    public void getKittens() throws Exception {
        lion = new Lion(feline,"Самец");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expect = 1;

        int actual = lion.getKittens();

        assertEquals(expect, actual);
    }

    @Test
    public void doesHaveManeOne() throws Exception {
        lion = new Lion(feline,"Самец");
        boolean expect = true;

        boolean actual = lion.hasMane;

        assertEquals(expect, actual);
    }

    @Test
    public void doesHaveManeTwo() throws Exception {
        lion = new Lion(feline,"Самка");
        boolean expect = false;

        boolean actual = lion.hasMane;

        assertEquals(expect, actual);
    }

    @Test
    public void doesHaveManeThree(){
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
        assertEquals(expect,actual);
    }

    @Test
    public void getFood() throws Exception {
        lion = new Lion(feline,"Самец");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expect = Arrays.asList("Животные", "Птицы", "Рыба");

        List<String> actual = lion.getFood();

        assertEquals(expect, actual);
    }
}
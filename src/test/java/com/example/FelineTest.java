package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline = new Feline();

    @Test
    public void whenCallEatMeaThenReturnList() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expect = Arrays.asList("Животные", "Птицы", "Рыба");

        List<String> actual = feline.eatMeat();

        assertEquals(expect, actual);
    }

    @Test
    public void whenCallGetFamilyThenReturnString() {
        String expect = "Кошачьи";

        String actual = feline.getFamily();

        assertEquals(expect, actual);
    }

    @Test
    public void whenCallGetKittensThenReturnInt() {
        int expect = 1;

        int actual = feline.getKittens();

        assertEquals(expect, actual);
    }

    @Test
    public void whenCallGetKittensWithIntThenReturnInt() {
        int expect = 5;

        int actual = feline.getKittens(expect);

        assertEquals(expect, actual);
    }
}
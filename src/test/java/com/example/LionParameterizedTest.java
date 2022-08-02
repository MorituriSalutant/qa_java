package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final Feline feline;
    private final String genderText;
    private final boolean expectHaveMane;

    public LionParameterizedTest(Feline feline, String genderText, boolean expectHaveMane) {
        this.feline = feline;
        this.genderText = genderText;
        this.expectHaveMane = expectHaveMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {new Feline(), "Самец", true},
                {new Feline(), "Самка", false}
        };
    }

    @Test
    public void whenCreateLionClassThenChangeMane() throws Exception {
        Lion lion = new Lion(feline, genderText);

        boolean actual = lion.doesHaveMane();

        assertEquals(expectHaveMane, actual);
    }


}


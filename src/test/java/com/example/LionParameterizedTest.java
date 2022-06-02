package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String genderText;
    private final boolean expectHaveMane;

    public LionParameterizedTest(String genderText, boolean expectHaveMane) {
        this.genderText = genderText;
        this.expectHaveMane = expectHaveMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManeTrue() throws Exception {
        Lion lion = new Lion(genderText);

        boolean actual = lion.doesHaveMane();

        assertEquals(expectHaveMane, actual);
    }


}


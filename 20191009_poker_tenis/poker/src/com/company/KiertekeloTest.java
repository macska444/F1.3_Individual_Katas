package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class KiertekeloTest {

    @Test
    public void rendezesTest(){

        List<Card> lapok =  Arrays.asList(
                new Card(Jel.FIVE, Color.KOR),
                new Card(Jel.FOUR, Color.KOR),
                new Card(Jel.SEVEN, Color.KOR)
        );
        Collections.sort(lapok);

        assertTrue(lapok.get(0).getJel().equals(Jel.FOUR));
        assertTrue(lapok.get(1).getJel().equals(Jel.FIVE));
        assertTrue(lapok.get(2).getJel().equals(Jel.SEVEN));

    }
}
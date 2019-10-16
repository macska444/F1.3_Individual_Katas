package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void cardSordingByCompareTest(){

        List<Card> lapok =  Arrays.asList(
                new Card(CardSign.FIVE, Color.HEARTH),
                new Card(CardSign.FOUR, Color.HEARTH),
                new Card(CardSign.SEVEN, Color.HEARTH)
        );
        Collections.sort(lapok);

        assertTrue(lapok.get(0).getCardSign().equals(CardSign.FOUR));
        assertTrue(lapok.get(1).getCardSign().equals(CardSign.FIVE));
        assertTrue(lapok.get(2).getCardSign().equals(CardSign.SEVEN));
    }
}
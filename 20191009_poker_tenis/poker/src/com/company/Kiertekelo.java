package com.company;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Kiertekelo {

    public Eredmeny kiertekel(List<Card> lapok){
        if(lapok == null){
            throw new NullPointerException("lapok");
        }
        if(lapok.size() != 5){
            throw new IllegalArgumentException("lapok száma nem 5");
        }

        Collections.sort(lapok);

        return null;
    }

}

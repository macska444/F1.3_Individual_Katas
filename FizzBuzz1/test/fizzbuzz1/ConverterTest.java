package fizzbuzz1;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class ConverterTest {
    public static Rules rules;
    
    @BeforeClass
    public static void setUpClass() {
        rules = new Rules();
        rules.addRule(3, "Fizz");
        rules.addRule(5, "Buzz");
    }
    
    
    @Test
    public void test1makes1() {
        System.out.println("test1makes1");
        Integer from = 1;
        String result = Converter.convert(from, rules);
        System.out.println(from + ": " + result);
        assertEquals("1",result);
    }


    @Test
    public void test2makes2() {
        System.out.println("test2makes2");
        Integer from = 2;
        String result = Converter.convert(from, rules);
        System.out.println(from + ": " + result);
        assertEquals("2",result);
    }

    @Test
    public void test3makesFizz() {
        System.out.println("test3makesFizz");
        Integer from = 3;
        String result = Converter.convert(from, rules);
        System.out.println(from + ": " + result);
        assertEquals("Fizz",result);
    }

    @Test
    public void test5makesBuzz() {
        System.out.println("test5makesBuzz");
        Integer from = 5;
        String result = Converter.convert(from, rules);
        System.out.println(from + ": " + result);
        assertEquals("Buzz",result);
    }
    
    @Test
    public void test15makesFizzBuzz() {
        System.out.println("test15makesFizzBuzz");
        Integer from = 15;
        String result = Converter.convert(from, rules);
        System.out.println(from + ": " + result);
        assertEquals("FizzBuzz",result);
    }

    @Test
    public void test17makes17() {
        System.out.println("test15makesFizzBuzz");
        Integer from = 17;
        String result = Converter.convert(from, rules);
        System.out.println(from + ": " + result);
        assertEquals("17",result);
    }
}

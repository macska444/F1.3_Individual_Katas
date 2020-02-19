package fizzbuzz1;

import org.junit.BeforeClass;
import org.junit.Test;

public class GeneratorTest {
    
    private static Generator fizzBuzz;
    private static Rules rules;
    
    @BeforeClass
    public static void setUpClass() {
        fizzBuzz = new Generator(0,1000);
        rules = new Rules();
        rules.addRule(4, "Lili");
        rules.addRule(5, "Lala");
        rules.addRule(11, "Macska");
    }

    @Test
    public void testGenerate() {
        fizzBuzz.generateWithRules(rules);
    }
    
}

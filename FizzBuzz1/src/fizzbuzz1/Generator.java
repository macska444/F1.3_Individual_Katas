package fizzbuzz1;

class Generator {
    private  int minimum =0;
    private  int maximum = 100;

    Generator(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }
    
    public void generate() {
        final Rules rules = new Rules();
        rules.addRule(3, "Fizz");
        rules.addRule(5, "Buzz");
        generateWithRules(rules);
    }
    
    public void generateWithRules(Rules rules) {
        if (rules == null){
            generate();
        }        
        for (int i = minimum; i < maximum; i++) {
            String result = Converter.convert(i,rules);
            System.out.println(String.valueOf(i) + " makes " + result);
        }
        
    }
    
}

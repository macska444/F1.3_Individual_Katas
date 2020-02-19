package fizzbuzz1;


public class Converter {

    public static String convert(Integer convertFrom, Rules rules) {
        String result= "";
        for (Integer multiplier : rules.getRuleList()) {
            if (convertFrom % multiplier == 0) {
                result += rules.getRule(multiplier);
            }
        }
        if (result.equals("")) {
            result = convertFrom.toString();
        }
        return result;
    }   
}

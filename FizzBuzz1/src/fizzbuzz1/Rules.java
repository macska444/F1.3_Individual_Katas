
package fizzbuzz1;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Rules {
    
    private Map<Integer,String> rules =  new TreeMap<>();

    public void addRule(Integer multiplier, String text) {
        rules.put(multiplier, text);
    }

    public void deleteRule(Integer multiplier) {
        rules.put(multiplier, "");
    }

    public String getRule(Integer multiplier) {
        String text = "";
        if (rules.containsKey(multiplier)) {
            text = rules.get(multiplier);
        }
        return text;
    }
    
    public Set<Integer> getRuleList() {
        return rules.keySet();
    }
    
}

package hu.idom.berlinclock;

public class BerlinClock {

    private static final String R_CHARACTER = "R";
    private static final String Y_CHARACTER = "Y";
    private static final String O_CHARACTER = "O";
    
    public String convertSingleMinutes(int minutes) {
        validateMinutes(minutes);
        int singleMinutes = minutes % 5;
        String result = createLeftCharsForMinutes(singleMinutes, false);
        return createResult(result, 4);
    }

    private String createLeftCharsForMinutes(int numberOfChars, boolean needRChar) {
        String result = "";
        for (int i = 0; i < numberOfChars; i++) {
            String character = Y_CHARACTER;
            if (needRChar && i % 3 == 2){
                character = R_CHARACTER;
            }
            result += character;
        }
        return result;
    }

    private void validateMinutes(int minutes){
        if (minutes < 0 || minutes > 59){
            throw new ClockException();
        }
    }
    
    public String convertFiveMinutes(int minutes) {
        validateMinutes(minutes);
        int numberOfFiveMinutes = minutes / 5;
        String result = createLeftCharsForMinutes(numberOfFiveMinutes, true);
        return createResult(result, 11);
    }
    
    private String createResult(String leftChars, int resultStringSize){
        String rightChars = "";
        for (int i = 0; i < resultStringSize; i++) {
            rightChars += O_CHARACTER;
        }
        String result = leftChars + rightChars;
        return result.substring(0, resultStringSize);
    }

    public String convertSingleHours(int hours) {
        validateHours(hours);
        int singleHours = hours % 5;
        String result = createLeftCharsForHours(singleHours);
        return createResult(result, 4);
    }
    
    private String createLeftCharsForHours(int numberOfChars) {
        String result = "";
        for (int i = 0; i < numberOfChars; i++) {
            String character = R_CHARACTER;
            result += character;
        }
        return result;
    }

    public String convertFiveHours(int hours) {
        int numberOfFiveHours = hours / 5;
        String result = createLeftCharsForHours(numberOfFiveHours);
        return createResult(result, 4);
    }

    public String convertSeconds(int seconds) {
        validateSeconds(seconds);
        return seconds % 2 == 0 ? Y_CHARACTER : O_CHARACTER;
    }
    
    private void validateSeconds(int seconds){
        if (seconds < 0 || seconds > 59){
            throw new ClockException();
        }
    }

    private void validateHours(int hours) {
        if (hours < 0 || hours > 23){
            throw new ClockException();
        }
    }

    public String convertTime(int hours, int minutes, int seconds) {
        return convertSeconds(seconds) + 
               convertFiveHours(hours) + 
               convertSingleHours(hours) + 
               convertFiveMinutes(minutes) + 
               convertSingleMinutes(minutes);
    }
    
}

package hu.idom.berlinclock;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class BerlinClockTest {
    
    private BerlinClock clock;
    
    @Before
    public void setUp(){
        clock = new BerlinClock();
    }
    
    @Test(expected = ClockException.class)
    public void invalidMinutes(){
        clock.convertSingleMinutes(65);
    }
    
    @Test
    public void convertSingleMinutes() {
        int minutes = 50;
        String resultSingleMinutes = clock.convertSingleMinutes(minutes);
        assertEquals("OOOO", resultSingleMinutes);
    }
    
    @Test
    public void convertSingleMinutes2() {
        int minutes = 52;
        String resultSingleMinutes = clock.convertSingleMinutes(minutes);
        assertEquals("YYOO", resultSingleMinutes);
    }
    
    @Test
    public void convertSingleMinutes3() {
        int minutes = 53;
        String resultSingleMinutes = clock.convertSingleMinutes(minutes);
        assertEquals("YYYO", resultSingleMinutes);
    }
    
    @Test
    public void convertFiveMinutes(){
        int minutes = 54;
        String result = clock.convertFiveMinutes(minutes);
        assertEquals("YYRYYRYYRYO", result);
    }
    
    @Test(expected = ClockException.class)
    public void invalidHours(){
        clock.convertSingleHours(24);
    }
    
    @Test
    public void convertSingleHours(){
        int hour = 17;
        String result = clock.convertSingleHours(hour);
        assertEquals("RROO", result);
    }
    
    @Test
    public void convertFiveHours(){
        int hour = 18;
        String result = clock.convertFiveHours(hour);
        assertEquals("RRRO", result);
    }
    
    @Test(expected = ClockException.class)
    public void invalidSeconds(){
        clock.convertSeconds(60);
    }
    
    @Test
    public void convertSeconds(){
        int seconds = 1;
        String result = clock.convertSeconds(seconds);
        assertEquals("O", result);
    }
    
    @Test
    public void convertTime(){
        String result = clock.convertTime(23, 59, 59);
        assertEquals("ORRRRRRROYYRYYRYYRYYYYYY", result);
    }
    
    @Test
    public void convertTime2(){
        String result = clock.convertTime(0, 0, 0);
        assertEquals("YOOOOOOOOOOOOOOOOOOOOOOO", result);
    }
    
    @Test
    public void convertTime3(){
        String result = clock.convertTime(16, 50, 6);
        assertEquals("YRRROROOOYYRYYRYYRYOOOOO", result);
    }
    
    @Test
    public void convertTime4(){
        String result = clock.convertTime(11, 37, 1);
        assertEquals("ORROOROOOYYRYYRYOOOOYYOO", result);
    }
}

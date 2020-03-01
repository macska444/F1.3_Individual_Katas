package magyar21;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HunCardRanksTest {

    @Test
    public void hasCardTest() {
        assertTrue(HunCardRanks.hasCard(7));
    }

    @Test
    public void hasCardFalseTest() {
        assertFalse(HunCardRanks.hasCard(1));
    }
}
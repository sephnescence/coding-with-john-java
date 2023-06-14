package RecentCounter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecentCounterTest {
    @Test
    void testScenarioOne() {
        RecentCounter recentCounter = new RecentCounter();

        assertEquals(
            recentCounter.ping(1),
            1
        );

        assertEquals(
            recentCounter.ping(100),
            2
        );

        assertEquals(
            recentCounter.ping(3001),
            3
        );

        // Bumping the previous 1 out of the 3000 window
        assertEquals(
            recentCounter.ping(3002),
            3
        );
    }

}
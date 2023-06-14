package MovingAverage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovingAverageTest {
    @Test
    void testScenarioOne() {
        MovingAverage movingAverage = new MovingAverage(3);

        assertEquals(
            1.0,
            movingAverage.next(1)
        );

        assertEquals(
            5.5,
            movingAverage.next(10)
        );

        movingAverage.next(3);
//        assertEquals(
//            4.66667,
//            movingAverage.next(3)
//        );

        assertEquals(
            6.0,
            movingAverage.next(5)
        );
    }
}
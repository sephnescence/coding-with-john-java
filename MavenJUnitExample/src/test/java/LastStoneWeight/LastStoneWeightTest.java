package LastStoneWeight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LastStoneWeightTest {
    @Test
    void testScenarioOne() {
        LastStoneWeight solution = new LastStoneWeight();

        assertEquals(
            1,
            solution.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1})
        );
    }

    @Test
    void testScenarioTwo() {
        LastStoneWeight solution = new LastStoneWeight();

        assertEquals(
            1,
            solution.lastStoneWeight(new int[]{1})
        );
    }

    @Test
    void testScenarioThree() {
        LastStoneWeight solution = new LastStoneWeight();

        assertEquals(
                2,
                solution.lastStoneWeight(new int[]{1, 3})
        );
    }

    @Test
    void testScenarioFour() {
        LastStoneWeight solution = new LastStoneWeight();

        assertEquals(
                0,
                solution.lastStoneWeight(new int[]{2, 2})
        );
    }
}
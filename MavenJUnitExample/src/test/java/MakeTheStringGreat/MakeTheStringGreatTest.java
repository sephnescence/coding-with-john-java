package MakeTheStringGreat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeTheStringGreatTest {
    @Test
    void testAssertPersonalScenario() {
        MakeTheStringGreat solution = new MakeTheStringGreat();

//        "abBAcC"
//                "leEeetcode"
        String response = solution.makeGood("abBAcC");

        // leetcode
        // <empty string>
        assertEquals("", response);
    }
}
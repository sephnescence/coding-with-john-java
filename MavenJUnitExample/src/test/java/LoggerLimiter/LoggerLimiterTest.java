package LoggerLimiter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LoggerLimiterTest {
    @Test
    void testAssertTrue() {
        assertTrue(true);
    }

    @Test
    void testMapPutWillOverride() {
        Map<Integer, Integer> testMap = new HashMap<>();

        testMap.put(100, 100);
        testMap.put(100, 200);

        assertTrue(testMap.get(100) - 200 == 0);
    }

    @Test
    void testCaseOne() {
        LoggerLimiter logger = new LoggerLimiter();

        boolean shouldPrintMessage = logger.shouldPrintMessage(0, "Hello");
        assertTrue(shouldPrintMessage);
        assertFalse(logger.shouldPrintMessage(1, "Hello"));
        assertTrue(logger.shouldPrintMessage(10, "Hello"));
    }

    @Test
    void testLeedcodeCaseOne() {
        // [[1,"foo"],[2,"bar"],[3,"foo"],[8,"bar"],[10,"foo"],[11,"foo"]]
        // [true,true,false,false,false,true]

        LoggerLimiter logger = new LoggerLimiter();

        assertTrue(logger.shouldPrintMessage(1, "foo"));
        assertTrue(logger.shouldPrintMessage(2, "bar"));
        assertFalse(logger.shouldPrintMessage(3, "foo"));
        assertFalse(logger.shouldPrintMessage(8, "bar"));
        assertFalse(logger.shouldPrintMessage(10, "foo"));
        assertTrue(logger.shouldPrintMessage(11, "foo"));
    }
}
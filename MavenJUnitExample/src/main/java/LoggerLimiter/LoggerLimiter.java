package LoggerLimiter;

import java.util.HashMap;
import java.util.Map;

public class LoggerLimiter { // 91%|67%
    public LoggerLimiter() {}

    Map<String, Integer> rateLimiter = new HashMap<>();

    // timestamp is in whole seconds
    public boolean shouldPrintMessage(int timestamp, String message) {
        // You'd possibly just hash this into an Integer, but we'll try with the whole string first
        if (!rateLimiter.containsKey(message)) {
            rateLimiter.put(message, timestamp+10);
            return true;
        }

        Integer lastSent = rateLimiter.get(message);

        if (timestamp >= lastSent) { // Might need to check for greater then, but the tests will show lol
            // testMapPutWillOverride tests that putting in a new value will override what was already there
            rateLimiter.put(message, timestamp+10);

            return true;
        }

        // I don't think this "resets" the timestamp as it wasn't in the brief
        return false;
    }
}

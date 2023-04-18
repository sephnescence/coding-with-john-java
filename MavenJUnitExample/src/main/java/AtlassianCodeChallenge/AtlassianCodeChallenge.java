package AtlassianCodeChallenge;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AtlassianCodeChallenge {
    public static void main(String[] args) {
        //

        RateLimiter rateLimiter = new RateLimiter();
        int customerAtlassian = 1;
        int customerGoogle = 2;

        int[] requests = new int[] {customerAtlassian, customerAtlassian, customerAtlassian, customerGoogle};
        for (int customerId : requests) {
            boolean isRateLimited = rateLimiter.rateLimit(customerId);

        }
    }

}
class RateLimiter {
    RateLimiter() {}

    // Rate limiter
    // Imagine we're trying to build an application that's used by many
    // Don't want one customer to abuse the rate
    // Each customer can make X requests per Y seconds

    public HashMap<Integer, HashMap<Long, Request>> customers = new HashMap<>();

    boolean rateLimit(int customerId) {
        Request req = new Request(customerId);
        HashMap<Long, Request> customerRequestLog;

        if (!customers.containsKey(customerId)) {
            customerRequestLog = new HashMap<>();
            customers.put(customerId, customerRequestLog);
        } else {
            customerRequestLog = customers.get(customerId);
        }

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Long utcTimestamp = timestamp.getTime();

        customerRequestLog.put(utcTimestamp, req);

//        System.out.println(customers);
        return customerRequestLog.size() >= 3; // won't take into account how many requests have actually happened over time
    }
}

class Request {
    Request(int customerId) {

    }
}

package RecentCounter;

import java.util.LinkedList;

public class RecentCounter {
    LinkedList<Integer> recentCallTimestamps = new LinkedList<>();
    int currentTimestamp = 0;

    public RecentCounter() {

    }

    public int ping(int t) {
        currentTimestamp = t;

        recentCallTimestamps.addLast(t);
        while (!recentCallTimestamps.isEmpty()) {
            Integer peekFirst = recentCallTimestamps.peekFirst();
            if (peekFirst < currentTimestamp - 3000) {
                recentCallTimestamps.removeFirst();
            } else {
                break;
            }
        }

        return recentCallTimestamps.size();
    }
}

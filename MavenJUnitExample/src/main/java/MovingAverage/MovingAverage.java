package MovingAverage;

import java.util.LinkedList;

public class MovingAverage {
    private LinkedList<Integer> history = new LinkedList<>();
    private int size = 0;
    private double runningSize = 0;
    private double historySize = 0;

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        runningSize += val;
        historySize++;

        history.addLast(val);

        while (historySize > size) {
            runningSize -= history.removeFirst();
            historySize--;
        }

        return runningSize / historySize;
    }
}

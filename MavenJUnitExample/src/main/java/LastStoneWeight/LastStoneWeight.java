package LastStoneWeight;

import java.util.Arrays;
import java.util.Collections;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // The point of this I guess is to use a max weight heap or whatever it's called
        // EASY, LOL. I've never had to use these before, or I likely did in uni but forgot

        int position = 0;
        while (stones.length - position > 1) {
            Arrays.sort(stones, 0, stones.length - position);
            int stoneOne = stones[stones.length - position - 1];
            int stoneTwo = stones[stones.length - position - 2];

            if (stoneOne == stoneTwo) {
                stones[stones.length - position - 2] = 0;
                position += 2;
                continue;
            }

            stones[stones.length - position++ - 2] = stoneOne - stoneTwo;
        }

        if (stones.length - position < 0) {
            return 0;
        }

        return stones[0];

    }
}

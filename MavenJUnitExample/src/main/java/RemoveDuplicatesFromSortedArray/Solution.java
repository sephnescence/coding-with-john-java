package RemoveDuplicatesFromSortedArray;

import java.util.ArrayList;

public class Solution {
    public int[] removeDuplicatesFromSortedArray(int[] nums) {
        ArrayList<Integer> numsList = new ArrayList<>();
        int currentNum = nums[0];
        numsList.add(currentNum);
        for (int i = 1; i < nums.length; i++) {
            if (currentNum != nums[i]) {
                currentNum = nums[i];
                numsList.add(currentNum);
            }
        }

        int[] returnNums = new int[numsList.size()];
        int position = 0;
        for (int num : numsList) {
            returnNums[position++] = num;
        }
        return returnNums;
    }
}

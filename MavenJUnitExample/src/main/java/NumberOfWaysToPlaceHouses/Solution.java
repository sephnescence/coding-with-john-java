package NumberOfWaysToPlaceHouses;

public class Solution {
    public static int[] fibonacci = new int[100003];
    public static int lastGeneratedFibonacci = 0;
    public int countHousePlacements(int n) {
        Solution.generateFibonacci(n + 2);

        int uniqueArrangementsPerRow = fibonacci[n+2];

        return uniqueArrangementsPerRow * uniqueArrangementsPerRow;
    }

    public static void generateFibonacci(int nPlusTwo) {
        if (lastGeneratedFibonacci == 0) {
            fibonacci[0] = 0;
            fibonacci[1] = 1;
            fibonacci[2] = 1;
            fibonacci[3] = 2;
            lastGeneratedFibonacci = 3;
        }

        if (lastGeneratedFibonacci > nPlusTwo) {
            return;
        }

        for (int i = lastGeneratedFibonacci; i < nPlusTwo; i++) {
            fibonacci[i+1] = fibonacci[i-1] + fibonacci[i];
        }
    }
}

package com.algorithms.array;

import java.util.HashMap;

/**
 * @author fanbo@imoran.net
 * @date 2021/3/28 6:51
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; ++i) {
            int tmp = target - numbers[i];
            if (map.containsKey(tmp)) {
                return new int[]{map.get(tmp), i};
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSumBruteForce(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; ++i) {
            for (int j = i + 1; j < numbers.length; ++j) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 3, 8, 15};
        TwoSum2 twoSum2 = new TwoSum2();
        twoSum2.twoSumBruteForce(arr, 10);
    }
}

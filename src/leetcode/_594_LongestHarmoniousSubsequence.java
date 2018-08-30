package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _594_LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int i : map.keySet()) {
            if (map.containsKey(i + 1)) {
                count = Math.max(count, map.get(i) + map.get(i + 1));
            }
        }
        return count;
    }

    public int findLHS_2(int[] nums) {
        Arrays.sort(nums);
        int longest = 0, index = 0, nextIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[index] + 1) {
                if (nums[nextIndex] < nums[i])
                    nextIndex = i;
                longest = Math.max(longest, i - index + 1);
            } else if (nums[i] - nums[index] > 1) {
                index = index == nextIndex ? i : nextIndex;
                i--;
            }
        }
        return longest;
    }

}

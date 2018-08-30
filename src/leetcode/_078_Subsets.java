package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _078_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        int pow = (int) Math.pow(2, nums.length);
        List<List<Integer>> lists = new ArrayList<>(pow);
        for (int i = 0; i < pow; i++) {
            ArrayList<Integer> integers = new ArrayList<>(nums.length);
            StringBuilder bin = new StringBuilder(Integer.toBinaryString(i));
            while (bin.length() < nums.length)
                bin.insert(0, '0');
            System.out.println(bin);
            for (int j = 0; j < nums.length; j++) {
                if (bin.charAt(j) == '1')
                    integers.add(nums[nums.length - j - 1]);
            }
            integers.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            lists.add(integers);
        }
        return lists;
    }

}

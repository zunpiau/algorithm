package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _347_TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequentMap = new HashMap<>();
        for (int num : nums) {
            frequentMap.put(num, frequentMap.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (Integer key : frequentMap.keySet()) {
            int frequent = frequentMap.get(key);
            if (bucket[frequent] == null) {
                bucket[frequent] = new ArrayList<>();
            }
            bucket[frequent].add(key);
        }
        ArrayList<Integer> topK = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0 && topK.size() < k; i--) {
            if (bucket[i] != null)
                topK.addAll(bucket[i]);
        }
        return topK;
    }

}

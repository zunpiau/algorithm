package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _763_PartitionLabels {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _763_PartitionLabels()
                .partitionLabels("ababcbacadefegdehijhklij")
                .toArray()));

    }

    public List<Integer> partitionLabels(String S) {
        ArrayList<Integer> partitions = new ArrayList<>();
        for (int i = 0, length = -1, partition = -1, lastIndex; i < S.length(); i++) {
            if (i > length) {
                length = S.lastIndexOf(S.charAt(i));
                partitions.add(length);
                partition++;
            } else if ((lastIndex = S.lastIndexOf(S.charAt(i))) > length) {
                length = lastIndex;
                partitions.set(partition, lastIndex);
            }
        }
        for (int i = partitions.size() - 1; i >= 1; i--) {
            partitions.set(i, partitions.get(i) - partitions.get(i - 1));
        }
        partitions.set(0, partitions.get(0) + 1);
        return partitions;
    }

}

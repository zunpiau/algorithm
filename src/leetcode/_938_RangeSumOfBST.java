package leetcode;

import common.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static common.CommonUtil.toTree;
import static org.junit.Assert.assertEquals;

/**
 * Date: 2019-01-01
 * Title: Range Sum of BST
 * Url: https://leetcode.com/problems/range-sum-of-bst/
 * Description:
 * Given the root node of a binary search tree,
 * return the sum of values of all nodes with value between L and R (inclusive).
 * The binary search tree is guaranteed to have unique values.
 * <p>
 * Example:
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * <p>
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 * <p>
 * Note:
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 */
public class _938_RangeSumOfBST {

    public static int rangeSumBST(TreeNode root, int L, int R) {
        Queue<TreeNode> queue = new LinkedList<>();
        addIfNotNull(root, queue);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val < L) addIfNotNull(poll.right, queue);
            else if (poll.val > R) addIfNotNull(poll.left, queue);
            else {
                sum += poll.val;
                addIfNotNull(poll.left, queue);
                addIfNotNull(poll.right, queue);
            }
        }
        return sum;
    }

    public static void addIfNotNull(TreeNode node, Queue<TreeNode> queue) {
        if (node != null) queue.add(node);
    }

    @Test
    public void test() {
        assertEquals(0, rangeSumBST(null, 7, 15));
        assertEquals(32, rangeSumBST(toTree(new int[]{10, 5, 15, 3, 7, 0, 18}, 0), 7, 15));
        assertEquals(23, rangeSumBST(toTree(new int[]{10, 5, 15, 3, 7, 13, 18, 1, 0, 6}, 0), 6, 10));
    }

}

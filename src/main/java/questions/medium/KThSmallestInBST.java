package questions.medium;

import utilclasses.TreeNode;

import java.util.Stack;

/**
 * Given the root of a binary search tree, and an integer k,
 * return the kth (1-indexed) smallest element in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 */
public class KThSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int count = 0;

        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);  // Just like recursion
                p = p.left;

            } else {
                TreeNode node = stack.pop();
                if(++count == k)
                    return node.val;
                p = node.right;
            }
        }

        return Integer.MIN_VALUE;
    }
}

package questions.medium;

import utilclasses.TreeNode;

import java.util.*;

public class BinaryTreeZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){

            List<Integer> tempList = new ArrayList<>();
            while(!s1.isEmpty()){
                final TreeNode current = s1.pop();
                tempList.add(current.val);
                s2.push(current.left);
                s2.push(current.right);
            }

            list.add(tempList);
            tempList = new ArrayList<>();
            while(!s2.isEmpty()){
                final TreeNode current = s2.pop();
                tempList.add(current.val);
                s1.push(current.right);
                s1.push(current.left);
            }
            if(!tempList.isEmpty())
                list.add(tempList);
        }

        return list;
    }

    /** use standard BFS to traversal the tree, but reversely adding element into result list in every odd level */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            /* use linkedlist to control time complexity of addFirst to O(1) */
            LinkedList<Integer> tempList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (reverse) {
                    tempList.addFirst(curNode.val);
                }
                else {
                    tempList.add(curNode.val);
                }

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            result.add(tempList);
            reverse = !reverse;
        }
        return result;
    }
}

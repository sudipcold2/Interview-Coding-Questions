package questions.medium;

import utilclasses.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if(root == null)
            return wrapList;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i < levelNum; i++) {

                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);

                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);

                subList.add(queue.poll().val);
            }

            wrapList.add(subList);
        }
        return wrapList;
    }
}
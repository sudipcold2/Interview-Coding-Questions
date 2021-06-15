package questions.medium;


public class PopulateNextRightPointersToEachNode {

    class TreeLinkNode {
        public int val;
        public TreeLinkNode left;
        public TreeLinkNode right;
        public TreeLinkNode next;

        public TreeLinkNode() {}

        public TreeLinkNode(int _val) {
            val = _val;
        }

        public TreeLinkNode(int _val, TreeLinkNode _left, TreeLinkNode _right, TreeLinkNode _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode cur = root;
        TreeLinkNode nextLeftmost = null;

        while(cur.left!=null){
            nextLeftmost = cur.left; // save the start of next level
            while(cur!=null){
                cur.left.next = cur.right;
                cur.right.next = cur.next == null ? null : cur.next.left;
                cur = cur.next;
            }
            cur = nextLeftmost;  // point to next level
        }
    }
}

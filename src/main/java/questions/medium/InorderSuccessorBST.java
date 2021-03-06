package questions.medium;

/**
 * In Binary Tree, Inorder successor of a node is the next node in Inorder traversal of the Binary Tree.
 * Inorder Successor is NULL for the last node in Inorder traversal.
 * In Binary Search Tree, Inorder Successor of an input node can also be defined as the
 * node with the smallest key greater than the key of the input node. So,
 * it is sometimes important to find next node in sorted order.
 */
public class InorderSuccessorBST {

    class Node {
        int data;
        Node left, right, parent;

        Node(int d) {
            data = d;
            left = right = parent = null;
        }
    }

    static Node head;

    Node insert(Node node, int data) {

        if (node == null) {
            return (new Node(data));
        }
        else {
            Node temp = null;
            if (data <= node.data) {
                temp = insert(node.left, data);
                node.left = temp;
            }
            else {
                temp = insert(node.right, data);
                node.right = temp;
            }

            temp.parent = node;
            return node;
        }
    }

    Node inOrderSuccessor(Node root, Node n) {

        // step 1 of the above algorithm
        if (n.right != null) {
            return minValue(n.right);
        }

        // step 2 of the above algorithm
        Node p = n.parent;
        while (p != null && n == p.right) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    Node minValue(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    
}

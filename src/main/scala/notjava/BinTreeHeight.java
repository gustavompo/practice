package notjava;

class Node {
    public Node(int dt) {
        this.data = dt;
    }

    public Node left;
    public Node right;
    public int data;
}

public class BinTreeHeight {

    private int innerH(Node node, int current) {
        int newH = current + 1;
        int leftH = 0;
        int rightH = 0;
        if (node.left != null)
            leftH = innerH(node.left, newH);
        if (node.right != null)
            rightH = innerH(node.right, newH);
        return Math.max(Math.max(current, leftH), rightH);
    }

    public int height(Node root) {
        return innerH(root, 0);
    }



    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}

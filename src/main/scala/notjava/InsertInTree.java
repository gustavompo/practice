package notjava;

public class InsertInTree {
    public static Node insert(Node root, int data) {
        if (data > root.data) {
            if (root.right == null) root.right = new Node(data);
            else insert(root.right, data);
        } else {
            if (root.left == null) root.left = new Node(data);
            else insert(root.left, data);
        }
        return root;
    }

}

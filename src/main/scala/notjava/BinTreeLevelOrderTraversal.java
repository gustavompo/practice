package notjava;

import java.util.ArrayList;
import java.util.List;

public class BinTreeLevelOrderTraversal {

    private static void printLevel(List<Node> nodes) {
        ArrayList<Node> next = new ArrayList<>();
        String line = nodes.stream().map(e -> {
            if (e.left != null) next.add(e.left);
            if (e.right != null) next.add(e.right);
            return "" + e.data;
        }).collect(java.util.stream.Collectors.joining(" "));
        System.out.print(line + " ");
        if (next.size() > 0)
            printLevel(next);
    }

    public static void levelOrder(Node root) {
        printLevel(new ArrayList<>());
    }
}

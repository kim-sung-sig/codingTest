import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Character, Node> tree = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            char parent = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);

            tree.putIfAbsent(parent, new Node(parent));
            Node parentNode = tree.get(parent);

            if (left != '.') {
                tree.putIfAbsent(left, new Node(left));
                parentNode.left = tree.get(left);
            }

            if (right != '.') {
                tree.putIfAbsent(right, new Node(right));
                parentNode.right = tree.get(right);
            }
        }

        System.out.println(preOrder(tree.get('A')));
        System.out.println(inOrder(tree.get('A')));
        System.out.println(postOrder(tree.get('A')));
    }

    static String preOrder(Node node) {
        if (node == null) {
            return "";
        }

        return node.value + preOrder(node.left) + preOrder(node.right);
    }

    static String inOrder(Node node) {
        if (node == null) {
            return "";
        }

        return inOrder(node.left) + node.value + inOrder(node.right);
    }

    static String postOrder(Node node) {
        if (node == null) {
            return "";
        }

        return postOrder(node.left) + postOrder(node.right) + node.value;
    }

}

class Node {
    char value;
    Node left, right;

    Node(char value) {
        this.value = value;
    }

}

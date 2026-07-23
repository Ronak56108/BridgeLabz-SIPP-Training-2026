public class BSTKthSmallest {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static int kthSmallest(Node root, int k) {
        java.util.Stack<Node> stack = new java.util.Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k--;
            if (k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }
        throw new IllegalArgumentException("k is larger than the number of nodes");
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        System.out.println(kthSmallest(root, 3));
    }
}

public class BSTValidate {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(Node root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(Node node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        System.out.println(isValidBST(root));

        Node invalid = new Node(5);
        invalid.left = new Node(1);
        invalid.right = new Node(4);
        invalid.right.left = new Node(3);
        invalid.right.right = new Node(6);
        System.out.println(isValidBST(invalid));
    }
}

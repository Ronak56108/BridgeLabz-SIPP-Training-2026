public class BSTDelete {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = delete(root.left, key);
        } else if (key > root.val) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.val = minValue(root.right);
            root.right = delete(root.right, root.val);
        }
        return root;
    }

    private static int minValue(Node node) {
        int minv = node.val;
        while (node.left != null) {
            node = node.left;
            minv = node.val;
        }
        return minv;
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root = delete(root, 10);
        inorder(root);
    }
}

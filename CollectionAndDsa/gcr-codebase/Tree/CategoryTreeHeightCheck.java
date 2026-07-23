public class CategoryTreeHeightCheck {
    static class Node {
        int id;
        Node left;
        Node right;

        Node(int id) {
            this.id = id;
        }
    }

    public static int height(Node node) {
        if (node == null) return -1;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static boolean isTooDeep(Node root, int threshold) {
        return height(root) > threshold;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        System.out.println(height(root));
        System.out.println(isTooDeep(root, 1));
    }
}}
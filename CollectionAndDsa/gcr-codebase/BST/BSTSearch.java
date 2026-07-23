public class BSTSearch {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static boolean search(Node root, int target) {
        Node current = root;
        while (current != null) {
            if (target == current.val) {
                return true;
            }
            current = (target < current.val) ? current.left : current.right;
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        System.out.println(search(root, 15));
        System.out.println(search(root, 7));
    }
}

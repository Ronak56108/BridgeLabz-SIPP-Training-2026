public class BSTLowestCommonAncestor {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        Node node = root;
        while (node != null) {
            if (p.val < node.val && q.val < node.val) {
                node = node.left;
            } else if (p.val > node.val && q.val > node.val) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        Node ancestor = lowestCommonAncestor(root, root.left, root.left.right);
        System.out.println(ancestor.val);
    }
}

public class DeleteFolderPostorder {
    static class Node {
        String name;
        Node left;
        Node right;

        Node(String name) {
            this.name = name;
        }
    }

    public static void deleteFolderTree(Node node) {
        if (node == null) return;
        deleteFolderTree(node.left);
        deleteFolderTree(node.right);
        System.out.println("Deleting " + node.name);
    }

    public static void main(String[] args) {
        Node root = new Node("root");
        root.left = new Node("child1");
        root.right = new Node("child2");
        root.left.left = new Node("child1.1");
        deleteFolderTree(root);
    }
}

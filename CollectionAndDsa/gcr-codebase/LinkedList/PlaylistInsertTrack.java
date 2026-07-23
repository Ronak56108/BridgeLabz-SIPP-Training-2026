public class PlaylistInsertTrack {
    static class Node {
        int trackId;
        Node next;

        Node(int trackId) {
            this.trackId = trackId;
        }
    }

    public static void insertAfter(Node current, int trackId) {
        if (current == null) return;
        Node newNode = new Node(trackId);
        newNode.next = current.next;
        current.next = newNode;
    }

    public static void printQueue(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.trackId + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        System.out.print("Before: ");
        printQueue(head);

        insertAfter(head.next, 99);

        System.out.print("After: ");
        printQueue(head);
    }
}

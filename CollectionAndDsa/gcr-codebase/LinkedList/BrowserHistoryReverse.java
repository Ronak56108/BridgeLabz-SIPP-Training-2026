public class BrowserHistoryReverse {
    static class Node {
        int pageId;
        Node next;

        Node(int pageId) {
            this.pageId = pageId;
        }
    }

    public static Node reverseHistory(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printHistory(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.pageId + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        System.out.print("Before: ");
        printHistory(head);

        head = reverseHistory(head);

        System.out.print("After: ");
        printHistory(head);
    }
}

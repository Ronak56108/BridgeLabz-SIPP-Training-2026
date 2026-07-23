public class RedirectLoopDetector {
    static class Node {
        int urlId;
        Node next;

        Node(int urlId) {
            this.urlId = urlId;
        }
    }

    public static boolean hasRedirectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        System.out.println("Has redirect loop: " + hasRedirectLoop(a));
    }
}

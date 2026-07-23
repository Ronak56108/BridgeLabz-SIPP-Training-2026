public class MiddleServerFinder {
    static class Node {
        int serverId;
        Node next;

        Node(int serverId) {
            this.serverId = serverId;
        }
    }

    public static Node findMiddleServer(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printChain(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.serverId + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        printChain(head);
        Node middle = findMiddleServer(head);
        System.out.println("Middle server ID: " + middle.serverId);
    }
}

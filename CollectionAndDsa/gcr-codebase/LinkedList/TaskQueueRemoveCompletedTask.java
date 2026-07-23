public class TaskQueueRemoveCompletedTask {
    static class Node {
        int taskId;
        Node next;

        Node(int taskId) {
            this.taskId = taskId;
        }
    }

    public static Node removeTask(Node head, int taskId) {
        if (head == null) return null;
        if (head.taskId == taskId) return head.next;

        Node prev = head;
        Node curr = head.next;
        while (curr != null && curr.taskId != taskId) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
        }
        return head;
    }

    public static void printTasks(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.taskId + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(101);
        head.next = new Node(102);
        head.next.next = new Node(103);

        System.out.print("Before: ");
        printTasks(head);

        head = removeTask(head, 102);

        System.out.print("After: ");
        printTasks(head);
    }
}

public class UndoBufferStack {
    private final String[] data;
    private int top;

    public UndoBufferStack(int maxDepth) {
        data = new String[maxDepth];
        top = -1;
    }

    public boolean push(String edit) {
        if (top == data.length - 1) {
            return false;
        }
        data[++top] = edit;
        return true;
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Nothing to undo");
        }
        return data[top--];
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Nothing to peek");
        }
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        UndoBufferStack undoStack = new UndoBufferStack(3);
        System.out.println(undoStack.push("edit1"));
        System.out.println(undoStack.push("edit2"));
        System.out.println(undoStack.push("edit3"));
        System.out.println(undoStack.push("edit4"));
        System.out.println("Peek: " + undoStack.peek());
        System.out.println("Undo: " + undoStack.pop());
    }
}

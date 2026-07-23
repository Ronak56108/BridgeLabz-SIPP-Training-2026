import java.util.ArrayList;
import java.util.List;

class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" + first + ", " + second + '}';
    }
}

class GenericStack<T> {
    private final List<T> elements = new ArrayList<>();

    public void push(T item) {
        elements.add(item);
    }

    public T pop() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}

class Repository<T> {
    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public boolean remove(T item) {
        return items.remove(item);
    }

    public List<T> findAll() {
        return new ArrayList<>(items);
    }

    public int count() {
        return items.size();
    }
}

public class PairAndStackDemo {
    public static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        T max = arr[0];
        for (T item : arr) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public static void printList(List<?> list) {
        System.out.println("List contents:");
        for (Object item : list) {
            System.out.println(" - " + item);
        }
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("age", 28);
        System.out.println(pair);

        GenericStack<String> stack = new GenericStack<>();
        stack.push("first");
        stack.push("second");
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Empty: " + stack.isEmpty());

        Integer[] numbers = {4, 2, 9, 1};
        System.out.println("Max value: " + findMax(numbers));

        Repository<String> repository = new Repository<>();
        repository.add("item1");
        repository.add("item2");
        printList(repository.findAll());
        System.out.println("Repository size: " + repository.count());
    }
}

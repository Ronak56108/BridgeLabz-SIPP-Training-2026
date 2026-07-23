import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private final String id;
    private final String name;

    protected WarehouseItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
    }
}

class Electronics extends WarehouseItem {
    Electronics(String id, String name) {
        super(id, name);
    }
}

class Groceries extends WarehouseItem {
    Groceries(String id, String name) {
        super(id, name);
    }
}

class Furniture extends WarehouseItem {
    Furniture(String id, String name) {
        super(id, name);
    }
}

class Storage<T extends WarehouseItem> {
    private final List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public boolean removeItem(T item) {
        return items.remove(item);
    }

    public List<T> getItems() {
        return new ArrayList<>(items);
    }
}

public class SmartWarehouseManagementSystem {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        System.out.println("Warehouse contents:");
        for (WarehouseItem item : items) {
            System.out.println(" - " + item);
        }
    }

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("E100", "Smartphone"));
        electronicsStorage.addItem(new Electronics("E101", "Laptop"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("G200", "Rice"));
        groceryStorage.addItem(new Groceries("G201", "Olive Oil"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("F300", "Dining Table"));

        displayAllItems(electronicsStorage.getItems());
        displayAllItems(groceryStorage.getItems());
        displayAllItems(furnitureStorage.getItems());
    }
}

import java.util.ArrayList;
import java.util.List;

abstract class ProductCategory {
    private final String name;

    protected ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class BookCategory extends ProductCategory {
    BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {
    ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    GadgetCategory() {
        super("Gadgets");
    }
}

class Product<T extends ProductCategory> {
    private final String title;
    private double price;
    private final T category;

    public Product(String title, double price, T category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("Product{title='%s', price=%.2f, category=%s}", title, price, category.getName());
    }
}

public class DynamicOnlineMarketplace {
    public static <T extends Product<? extends ProductCategory>> void applyDiscount(T product, double percentage) {
        double discounted = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discounted);
    }

    public static void printCatalog(List<? extends Product<? extends ProductCategory>> catalog) {
        System.out.println("Marketplace catalog:");
        for (Product<? extends ProductCategory> product : catalog) {
            System.out.println(" - " + product);
        }
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Basics", 350.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Denim Jacket", 1200.0, new ClothingCategory());
        Product<GadgetCategory> gadget = new Product<>("Wireless Earbuds", 2500.0, new GadgetCategory());

        List<Product<? extends ProductCategory>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(gadget);

        printCatalog(catalog);

        applyDiscount(book, 20);
        applyDiscount(shirt, 15);
        applyDiscount(gadget, 10);

        System.out.println("\nAfter applying discounts:");
        printCatalog(catalog);
    }
}

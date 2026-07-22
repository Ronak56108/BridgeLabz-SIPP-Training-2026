public class FoodDeliverySystem {
    public static void main(String[] args) {
        VegItem vegItem = new VegItem("Paneer Wrap", 120, 2);
        NonVegItem nonVegItem = new NonVegItem("Chicken Burger", 180, 1, 50);

        vegItem.displayItemDetails();
        System.out.println("Total Price: " + vegItem.calculateTotalPrice() + "\n");

        nonVegItem.displayItemDetails();
        System.out.println("Total Price: " + nonVegItem.calculateTotalPrice());
    }
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        setItemName(itemName);
        setPrice(price);
        setQuantity(quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem {
    private double serviceCharge;

    public NonVegItem(String itemName, double price, int quantity, double serviceCharge) {
        setItemName(itemName);
        setPrice(price);
        setQuantity(quantity);
        this.serviceCharge = serviceCharge;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + serviceCharge;
    }
}

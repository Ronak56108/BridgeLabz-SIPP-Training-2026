public class DeliveryExecutiveDemo {
    public static void main(String[] args) {
        String[] customers = {"Alice", "Bob", "Charlie"};
        DeliveryExecutive executive = new DeliveryExecutive();

        for (String customer : customers) {
            System.out.println("Customer: " + customer);
            executive.trackOrder();
            System.out.println("Delivery code: " + GroceryDelivery.generateDeliveryCode() + "\n");
        }
    }
}

interface FoodDelivery {
    default void trackOrder() {
        System.out.println("Tracking food delivery order.");
    }
}

interface GroceryDelivery {
    default void trackOrder() {
        System.out.println("Tracking grocery delivery order.");
    }

    static String generateDeliveryCode() {
        return "DEL" + System.currentTimeMillis();
    }
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {
    @Override
    public void trackOrder() {
        System.out.println("Delivery executive tracking all orders.");
    }
}

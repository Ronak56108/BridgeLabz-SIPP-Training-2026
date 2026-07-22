public class RestaurantWorkerDemo {
    public static void main(String[] args) {
        Chef chef = new Chef("C001", "Ravi");
        Waiter waiter = new Waiter("W001", "Sara");

        chef.performDuties();
        System.out.println();
        waiter.performDuties();
    }
}

class Person {
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

interface Worker {
    void performDuties();
}

class Chef extends Person implements Worker {
    public Chef(String id, String name) {
        super(id, name);
    }

    @Override
    public void performDuties() {
        System.out.println("Chef " + getName() + " is cooking meals.");
    }
}

class Waiter extends Person implements Worker {
    public Waiter(String id, String name) {
        super(id, name);
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter " + getName() + " is serving customers.");
    }
}

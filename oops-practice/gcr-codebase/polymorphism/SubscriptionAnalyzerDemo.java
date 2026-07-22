public class SubscriptionAnalyzerDemo {
    public static void main(String[] args) {
        SubscriptionPlan[] subscriptions = {
            new BasicSubscription("Alice", "SUB100", 299),
            new PremiumSubscription("Bob", "SUB200", 499),
            new FamilySubscription("Charlie", "SUB300", 799)
        };

        System.out.println("Total Monthly Revenue: " + calculateTotalRevenue(subscriptions));
        System.out.println("Most expensive subscription: " + findMostExpensiveSubscription(subscriptions).getSubscriberName());
        System.out.println("Subscribers starting with 'A':");
        displaySubscribersStartingWith(subscriptions, 'A');
    }

    public static double calculateTotalRevenue(SubscriptionPlan[] subscriptions) {
        double total = 0;
        for (SubscriptionPlan subscription : subscriptions) {
            total += subscription.calculateMonthlyCharge();
        }
        return total;
    }

    public static SubscriptionPlan findMostExpensiveSubscription(SubscriptionPlan[] subscriptions) {
        SubscriptionPlan max = subscriptions[0];
        for (SubscriptionPlan subscription : subscriptions) {
            if (subscription.calculateMonthlyCharge() > max.calculateMonthlyCharge()) {
                max = subscription;
            }
        }
        return max;
    }

    public static void displaySubscribersStartingWith(SubscriptionPlan[] subscriptions, char letter) {
        for (SubscriptionPlan subscription : subscriptions) {
            if (subscription.getSubscriberName().startsWith(String.valueOf(letter))) {
                System.out.println(subscription.getSubscriberName());
            }
        }
    }
}

abstract class SubscriptionPlan {
    private String subscriberName;
    private String subscriptionId;

    public SubscriptionPlan(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public abstract double calculateMonthlyCharge();
}

class BasicSubscription extends SubscriptionPlan {
    private double charge;

    public BasicSubscription(String subscriberName, String subscriptionId, double charge) {
        super(subscriberName, subscriptionId);
        this.charge = charge;
    }

    @Override
    public double calculateMonthlyCharge() {
        return charge;
    }
}

class PremiumSubscription extends SubscriptionPlan {
    private double charge;

    public PremiumSubscription(String subscriberName, String subscriptionId, double charge) {
        super(subscriberName, subscriptionId);
        this.charge = charge;
    }

    @Override
    public double calculateMonthlyCharge() {
        return charge;
    }
}

class FamilySubscription extends SubscriptionPlan {
    private double charge;

    public FamilySubscription(String subscriberName, String subscriptionId, double charge) {
        super(subscriberName, subscriptionId);
        this.charge = charge;
    }

    @Override
    public double calculateMonthlyCharge() {
        return charge;
    }
}

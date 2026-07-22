public class NotificationSystemDemo {
    public static void main(String[] args) {
        Notification[] notifications = {
            new EmailNotification("Alice", "Your order has shipped."),
            new SMSNotification("Bob", "Your OTP is 123456."),
            new PushNotification("Charlie", "New message received.")
        };

        for (Notification notification : notifications) {
            notification.sendNotification();
            System.out.println();
        }
    }
}

class Notification {
    private String recipientName;
    private String message;

    public Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getMessage() {
        return message;
    }

    public void sendNotification() {
        System.out.println("Generic notification to " + recipientName + ": " + message);
    }
}

class EmailNotification extends Notification {
    public EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("Email sent to " + getRecipientName() + ": " + getMessage());
    }
}

class SMSNotification extends Notification {
    public SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("SMS sent to " + getRecipientName() + ": " + getMessage());
    }
}

class PushNotification extends Notification {
    public PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("Push notification sent to " + getRecipientName() + ": " + getMessage());
    }
}

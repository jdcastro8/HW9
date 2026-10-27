public abstract class PaymentNotification {

    protected NotificationChannel channel;

    public PaymentNotification(NotificationChannel channel) {
        this.channel = channel;
    }

    public abstract String notifyPayment();
}
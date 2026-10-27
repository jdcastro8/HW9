public class CashOnDeliveryPayment extends PaymentNotification {

    public CashOnDeliveryPayment(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public String notifyPayment() {
        return channel.send("Your order will be paid upon delivery.");
    }
}
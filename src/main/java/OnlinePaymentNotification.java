public class OnlinePaymentNotification extends PaymentNotification {

    public OnlinePaymentNotification(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public String notifyPayment() {
        return channel.send("Your online payment was successful.");
    }
}
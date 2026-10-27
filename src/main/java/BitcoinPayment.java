public class BitcoinPayment extends PaymentNotification {

    public BitcoinPayment(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public String notifyPayment() {
        return channel.send("Your Bitcoin payment was successful.");
    }
}
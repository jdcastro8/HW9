import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BridgeTest {

    @Test
    public void testEmailChannel() {
        NotificationChannel channel = new EmailChannel();

        assertEquals("Email: Test message", channel.send("Test message"));
    }

    @Test
    public void testSmsChannel() {
        NotificationChannel channel = new SmsChannel();

        assertEquals("SMS: Test message", channel.send("Test message"));
    }

    @Test
    public void testPushChannel() {
        NotificationChannel channel = new PushChannel();

        assertEquals("Push: Test message", channel.send("Test message"));
    }

    @Test
    public void testOnlinePayment() {
        PaymentNotification notification =
                new OnlinePaymentNotification(new EmailChannel());

        assertEquals(
                "Email: Your online payment was successful.",
                notification.notifyPayment()
        );
    }

    @Test
    public void testCashOnDeliveryPayment() {
        PaymentNotification notification =
                new CashOnDeliveryPayment(new SmsChannel());

        assertEquals(
                "SMS: Your order will be paid upon delivery.",
                notification.notifyPayment()
        );
    }

    @Test
    public void testBitcoinPayment() {
        PaymentNotification notification =
                new BitcoinPayment(new PushChannel());

        assertEquals(
                "Push: Your Bitcoin payment was successful.",
                notification.notifyPayment()
        );
    }

    @Test
    public void testBridgeCombinations() {
        NotificationChannel[] channels = {
                new EmailChannel(),
                new SmsChannel(),
                new PushChannel()
        };

        for (NotificationChannel channel : channels) {
            assertDoesNotThrow(() -> {
                new OnlinePaymentNotification(channel).notifyPayment();
                new CashOnDeliveryPayment(channel).notifyPayment();
                new BitcoinPayment(channel).notifyPayment();
            });
        }
    }
}
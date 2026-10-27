public class BridgeDemo {

    public static void main(String[] args) {

        PaymentNotification onlineEmail =
                new OnlinePaymentNotification(new EmailChannel());

        PaymentNotification onlineSms =
                new OnlinePaymentNotification(new SmsChannel());

        PaymentNotification cashEmail =
                new CashOnDeliveryPayment(new EmailChannel());

        PaymentNotification cashSms =
                new CashOnDeliveryPayment(new SmsChannel());

        PaymentNotification bitcoinEmail =
                new BitcoinPayment(new EmailChannel());

        PaymentNotification bitcoinSms =
                new BitcoinPayment(new SmsChannel());

        PaymentNotification onlinePush =
                new OnlinePaymentNotification(new PushChannel());

        PaymentNotification cashPush =
                new CashOnDeliveryPayment(new PushChannel());

        System.out.println(onlineEmail.notifyPayment());
        System.out.println(onlineSms.notifyPayment());
        System.out.println(cashEmail.notifyPayment());
        System.out.println(cashSms.notifyPayment());
        System.out.println(bitcoinEmail.notifyPayment());
        System.out.println(bitcoinSms.notifyPayment());
        System.out.println(onlinePush.notifyPayment());
        System.out.println(cashPush.notifyPayment());
    }
}
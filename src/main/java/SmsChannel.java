public class SmsChannel implements NotificationChannel {

    @Override
    public String send(String message) {
        return "SMS: " + message;
    }
}
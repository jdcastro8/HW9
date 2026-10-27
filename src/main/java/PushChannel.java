public class PushChannel implements NotificationChannel {

    @Override
    public String send(String message) {
        return "Push: " + message;
    }
}
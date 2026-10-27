public class EmailChannel implements NotificationChannel {

    @Override
    public String send(String message) {
        return "Email: " + message;
    }
}
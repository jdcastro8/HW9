public class LoyaltyStatus {

    private String status;

    public LoyaltyStatus(String status) {
        this.status = status;
    }

    public double applyDiscount(double total) {

        if (status.equalsIgnoreCase("Gold")) {
            return total * 0.80;
        }

        if (status.equalsIgnoreCase("Silver")) {
            return total * 0.90;
        }

        return total;
    }
}
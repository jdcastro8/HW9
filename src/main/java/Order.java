import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<FoodItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;

        for (FoodItem item : items) {
            total += item.getCost();
        }

        return total;
    }

    public void printOrder() {
        System.out.println("Customer Order:");

        for (FoodItem item : items) {
            System.out.printf("%s: $%.2f%n",
                    item.getDescription(), item.getCost());
        }

        System.out.printf("Subtotal: $%.2f%n", calculateTotal());
    }
}
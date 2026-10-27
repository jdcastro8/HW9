public class DecoratorDemo {

    public static void main(String[] args) {

        FoodItem burger = new Cheese(new Ketchup(new Burger()));

        FoodItem fries = new Onions(new Fries());

        FoodItem hotDog = new Cheese(new Onions(new HotDog()));

        Order order = new Order();

        order.addItem(burger);
        order.addItem(fries);
        order.addItem(hotDog);

        order.printOrder();

        LoyaltyStatus regular = new LoyaltyStatus("Regular");
        LoyaltyStatus silver = new LoyaltyStatus("Silver");
        LoyaltyStatus gold = new LoyaltyStatus("Gold");

        double total = order.calculateTotal();

        System.out.printf("Regular Total: $%.2f%n",
                regular.applyDiscount(total));

        System.out.printf("Silver Total: $%.2f%n",
                silver.applyDiscount(total));

        System.out.printf("Gold Total: $%.2f%n",
                gold.applyDiscount(total));
    }
}
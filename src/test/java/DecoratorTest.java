import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class DecoratorTest {

    @Test
    public void testBurger() {
        FoodItem burger = new Burger();

        assertEquals("Burger", burger.getDescription());
        assertEquals(5.00, burger.getCost(), 0.001);
    }

    @Test
    public void testFries() {
        FoodItem fries = new Fries();

        assertEquals("Fries", fries.getDescription());
        assertEquals(2.50, fries.getCost(), 0.001);
    }

    @Test
    public void testHotDog() {
        FoodItem hotDog = new HotDog();

        assertEquals("Hot Dog", hotDog.getDescription());
        assertEquals(3.50, hotDog.getCost(), 0.001);
    }

    @Test
    public void testCheeseDecorator() {
        FoodItem item = new Cheese(new Burger());

        assertEquals("Burger + Cheese", item.getDescription());
        assertEquals(6.00, item.getCost(), 0.001);
    }

    @Test
    public void testKetchupDecorator() {
        FoodItem item = new Ketchup(new Fries());

        assertEquals("Fries + Ketchup", item.getDescription());
        assertEquals(2.75, item.getCost(), 0.001);
    }

    @Test
    public void testOnionsDecorator() {
        FoodItem item = new Onions(new HotDog());

        assertEquals("Hot Dog + Onions", item.getDescription());
        assertEquals(4.00, item.getCost(), 0.001);
    }

    @Test
    public void testMultipleToppings() {
        FoodItem item = new Cheese(new Ketchup(new Burger()));

        assertEquals("Burger + Ketchup + Cheese", item.getDescription());
        assertEquals(6.25, item.getCost(), 0.001);
    }

    @Test
    public void testOrderTotal() {
        Order order = new Order();

        order.addItem(new Burger());
        order.addItem(new Fries());
        order.addItem(new HotDog());

        assertEquals(11.00, order.calculateTotal(), 0.001);
    }

    @Test
    public void testOrderWithToppings() {
        Order order = new Order();

        order.addItem(new Cheese(new Burger()));
        order.addItem(new Ketchup(new Fries()));

        assertEquals(8.75, order.calculateTotal(), 0.001);
    }

    @Test
    public void testPrintOrder() {
        Order order = new Order();

        order.addItem(new Burger());

        assertDoesNotThrow(order::printOrder);
    }

    @Test
    public void testRegularDiscount() {
        LoyaltyStatus loyalty = new LoyaltyStatus("Regular");

        assertEquals(100.00, loyalty.applyDiscount(100.00), 0.001);
    }

    @Test
    public void testSilverDiscount() {
        LoyaltyStatus loyalty = new LoyaltyStatus("Silver");

        assertEquals(90.00, loyalty.applyDiscount(100.00), 0.001);
    }

    @Test
    public void testGoldDiscount() {
        LoyaltyStatus loyalty = new LoyaltyStatus("Gold");

        assertEquals(80.00, loyalty.applyDiscount(100.00), 0.001);
    }
}
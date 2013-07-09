import org.junit.Test;

import static junit.framework.Assert.*;

public class CheckoutTester {
    private int price(String... items) {
        Checkout checkout = new CheckoutFactory().create();
        for (String item : items) {
            checkout.scan(item);
        }

        return checkout.total();
    }

    @Test
    public void emptyBasket() {
        assertEquals(0, price(""));
    }

    @Test
    public void singleItem() {
        assertEquals(50, price("A"));
        assertEquals(30, price("B"));
        assertEquals(20, price("C"));
        assertEquals(15, price("D"));
    }

    @Test
    public void multipleItemsAddsPrice() {
        assertEquals(100, price("AA"));
    }

    @Test
    public void ThreeAsGetsA20pDiscount() {
        assertEquals(130, price("AAA"));
        assertEquals(180, price("AAAA"));
    }
}

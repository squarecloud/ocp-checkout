import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultipleItemDiscount implements PricingRule{
    Multiset<String> discountItems = HashMultiset.create();
    private final String item;
    private final int quantity;
    private final int price;

    public MultipleItemDiscount(String item, int quantity, int price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;

        discountItems.setCount(item, quantity);
    }

    @Override
    public void payFor(Basket basket) {
        while (basket.itemsLeft().count(item) >= quantity) {
            basket.payFor(discountItems, price);
        }
    }
}

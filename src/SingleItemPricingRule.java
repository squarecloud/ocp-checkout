import com.google.common.collect.Multiset;

public class SingleItemPricingRule implements PricingRule {
    private ItemPrice itemPrice;

    public SingleItemPricingRule(ItemPrice itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public void payFor(Basket basket) {
        int total = 0;

        Multiset<String> allItems = basket.itemsLeft();
        for (String item : allItems) {
            total += itemPrice.price(item);
        }

        basket.payFor(allItems, total);
    }
}

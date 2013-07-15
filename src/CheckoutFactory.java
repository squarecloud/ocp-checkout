import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutFactory {

    public Checkout create() {
        Map<String, Integer> prices = new HashMap();
        prices.put("A", 50);
        prices.put("B", 30);
        prices.put("C", 20);
        prices.put("D", 15);

        ItemPrice itemPrices = new ItemPrice(prices);

        List<ItemListener> itemListeners = new ArrayList<ItemListener>();
        itemListeners.add(new SingleItemPrice(itemPrices));
        itemListeners.add(new MultipleItemDiscount("A", 3, 20));
        itemListeners.add(new MultipleItemDiscount("B", 2, 15));

        return new Checkout(new Total(), itemListeners);
    }
}

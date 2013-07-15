
import java.util.Map;

public class ItemPrice {
    public ItemPrice(Map<String, Integer> prices) {
        this.prices = prices;
    }

    Map<String, Integer> prices;

    public int lookup(String item) {
        return prices.get(item);
    }
}

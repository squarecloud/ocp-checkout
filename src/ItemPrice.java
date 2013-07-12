import java.util.HashMap;
import java.util.Map;

public class ItemPrice {
    private Map<String, Integer> prices = new HashMap<String, Integer>();

    public ItemPrice() {
        prices.put("", 0);
        prices.put("A", 50);
        prices.put("B", 30);
        prices.put("C", 20);
        prices.put("D", 15);
    }

    public int price(String item) {
        return prices.get(item);
    }
}

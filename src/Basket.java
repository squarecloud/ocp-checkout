import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class Basket {
    private Multiset<String> items = HashMultiset.create();
    private int total = 0;

    public void add(String item) {
        items.add(item);
    }

    public Multiset<String> itemsLeft() {
        return items;
    }

    public void payFor(Multiset<String> purchased, int price) {
        removeItems(purchased);
        total += price;
    }

    private void removeItems(Multiset<String> purchased) {
        for (String purchasedItem : purchased.elementSet()) {
            items.setCount(purchasedItem, items.count(purchasedItem) - purchased.count(purchasedItem));
        }
    }

    public int price() {
        return total;
    }
}

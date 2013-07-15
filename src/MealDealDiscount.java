import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class MealDealDiscount implements ItemListener, PriceListener {
    int individualItemPrice = 0;
    ItemPrice itemPrice;
    List<ItemGroup> groups;

    public MealDealDiscount(ItemPrice itemPrice) {
        this.itemPrice = itemPrice;

        groups = Lists.newArrayList();
        groups.add(new ItemGroup("A"));
        groups.add(new ItemGroup("B"));
        groups.add(new ItemGroup("C", "D"));
    }

    @Override
    public void notifyItem(String item, PriceListener priceListener) {
        boolean allSeen = true;

        for (ItemGroup group : groups) {
            group.seenItem(item);
            allSeen = allSeen && group.seenItem;
        }

        if(allSeen) {
            priceListener.add(85 - individualItemPrice);
            reset();
        }
    }

    private void reset() {
        for (ItemGroup group : groups) {
            group.reset();
        }

        individualItemPrice = 0;
    }

    private void addItemPrice(String item) {
        individualItemPrice += itemPrice.lookup(item);
    }

    @Override
    public void add(int amount) {
        individualItemPrice += amount;
    }

    class ItemGroup {
        List<String> items;
        boolean seenItem = false;

        public ItemGroup(String... items) {
            this.items = Arrays.asList(items);
        }

        public void seenItem(String item) {
            if(items.contains(item)) {
                seenItem = true;
                addItemPrice(item);
            }
        }

        public void reset() {
            seenItem = false;
        }
    }

}

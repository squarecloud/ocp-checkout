public class SingleItemPrice implements ItemListener {
    private ItemPrice itemPrice;

    public SingleItemPrice(ItemPrice itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void notifyItem(String item, PriceListener priceListener) {
        priceListener.add(itemPrice.lookup(item));
    }
}

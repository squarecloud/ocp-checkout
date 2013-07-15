public class SingleItemPrice implements ItemListener {
    private ItemPrice itemPrice;

    public SingleItemPrice(ItemPrice itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void notifyItem(String item, Total total) {
        total.add(itemPrice.lookup(item));
    }
}

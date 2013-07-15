public class MultipleItemDiscount implements ItemListener {
    private final String item;
    private final int quantity;
    private final int discountAmount;

    int count = 0;

    public MultipleItemDiscount(String item, int quantity, int discountAmount) {
        this.item = item;
        this.quantity = quantity;
        this.discountAmount = discountAmount;
    }

    @Override
    public void notifyItem(String receivedItem, PriceListener priceListener) {
        if(receivedItem.equals(item)) {
            count++;
        }

        if(count == quantity) {
            priceListener.add(-discountAmount);
            count = 0;
        }
    }
}

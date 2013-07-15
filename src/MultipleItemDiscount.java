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
    public void notifyItem(String receivedItem, Total total) {
        if(receivedItem.equals(item)) {
            count++;
        }

        if(count == quantity) {
            total.add(-discountAmount);
            count = 0;
        }
    }
}

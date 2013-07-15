import java.util.List;

public class Checkout {
    private Total total;

    private List<ItemListener> itemListeners;

    public Checkout(Total total, List<ItemListener> itemListeners) {
        this.total = total;
        this.itemListeners = itemListeners;
    }

    public void scan(String item) {
        for (ItemListener itemListener : itemListeners) {
            itemListener.notifyItem(item, total);
        }
    }

    public int total() {
        return total.sum();
    }
}

public class Checkout {
    private ItemPricer itemPricer;
    private Totaller totaller;

    public Checkout(ItemPricer itemPricer, Totaller totaller) {
        this.itemPricer = itemPricer;
        this.totaller = totaller;
    }

    public void scan(String item) {
        totaller.add(itemPricer.price(item));
    }

    public int total() {
        return totaller.total();
    }
}

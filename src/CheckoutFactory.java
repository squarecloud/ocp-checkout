public class CheckoutFactory {

    public Checkout create() {
        return new Checkout(new ItemPricer(), new Totaller());
    }
}

public class Checkout {
    private Basket basket;
    private PricingRules rules;

    public Checkout(Basket basket, PricingRules rules) {
        this.basket = basket;
        this.rules = rules;
    }

    public void scan(String item) {
        basket.add(item);
    }

    public int total() {
        return rules.price(basket);
    }
}

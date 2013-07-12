public class CheckoutFactory {

    public Checkout create() {
        Basket basket = new Basket();
        PricingRules rules = new PricingRules(new MultipleItemDiscount("A", 3, 130), new SingleItemPricingRule(new ItemPrice()));
        return new Checkout(basket, rules);
    }
}

public class PricingRules {

    private PricingRule[] rules;

    public PricingRules(PricingRule... rules) {
        this.rules = rules;
    }

    public int price(Basket basket) {
        for(PricingRule rule : rules) {
            rule.payFor(basket);
        }

        return basket.price();
    }
}

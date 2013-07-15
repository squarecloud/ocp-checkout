public class Total implements PriceListener {
    int total = 0;

    @Override
    public void add(int amount) {
        total += amount;
    }

    public int sum() {
        return total;
    }
}

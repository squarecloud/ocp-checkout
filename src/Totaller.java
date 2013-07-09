public class Totaller {
    private int total = 0;

    public void add(int price) {
        total  += price;
    }

    public int total() {
        return total;
    }
}

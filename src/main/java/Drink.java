public class Drink implements Item {
    private DrinkSize size;

    public Drink(DrinkSize size) {
        this.size = size;
    }

    @Override
    public double calculatePrice() {
        return size.getPrice();
    }

    @Override
    public String toString() {
        return size + " Drink - $" + calculatePrice();
    }
}

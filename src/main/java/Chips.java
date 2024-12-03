public class Chips implements Item {
    private ChipFlavor flavor;

    public Chips(ChipFlavor flavor) {
        this.flavor = flavor;
    }

    @Override
    public double calculatePrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return flavor + " Chips - $1.50";
    }
}

public enum SandwichSize {
    SMALL(4, 5.50), MEDIUM(8, 7.00), LARGE(12, 8.50);

    private final int size;
    private final double basePrice;

    SandwichSize(int size, double basePrice) {
        this.size = size;
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }
}

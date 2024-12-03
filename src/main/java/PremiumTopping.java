public enum PremiumTopping {
    STEAK(1.00, 2.00, 3.00),
    HAM(1.00, 2.00, 3.00),
    SALAMI(1.00, 2.00, 3.00),
    ROAST_BEEF(1.00, 2.00, 3.00),
    CHICKEN(1.00, 2.00, 3.00),
    BACON(1.00, 2.00, 3.00),
    AMERICAN_CHEESE(0.75, 1.50, 2.25),
    PROVOLONE(0.75, 1.50, 2.25),
    CHEDDAR(0.75, 1.50, 2.25),
    SWISS(0.75, 1.50, 2.25);

    private final double smallPrice;
    private final double mediumPrice;
    private final double largePrice;

    PremiumTopping(double smallPrice, double mediumPrice, double largePrice) {
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
    }

    public double getPrice(SandwichSize size) {
        return size == SandwichSize.SMALL ? smallPrice :
                size == SandwichSize.MEDIUM ? mediumPrice : largePrice;
    }
}

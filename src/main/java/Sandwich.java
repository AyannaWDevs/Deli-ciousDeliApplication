import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Item {
    private SandwichSize size;
    private BreadType breadType;
    private List<PremiumTopping> premiumToppings;
    private List<RegularTopping> regularToppings;
    private List<PremiumTopping> extraPremiumToppings; // For extra servings
    private boolean toasted;

    public Sandwich(SandwichSize size, BreadType breadType) {
        this.size = size;
        this.breadType = breadType;
        this.premiumToppings = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.extraPremiumToppings = new ArrayList<>();
    }

    public void addPremiumTopping(PremiumTopping topping) {
        premiumToppings.add(topping);
    }

    public void addRegularTopping(RegularTopping topping) {
        regularToppings.add(topping);
    }

    public void addExtraPremiumTopping(PremiumTopping topping) {
        extraPremiumToppings.add(topping);
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    @Override
    public double calculatePrice() {
        double price = size.getBasePrice();

        // Add price for premium toppings
        for (PremiumTopping topping : premiumToppings) {
            price += topping.getPrice(size);
        }

        // Add price for extra premium toppings
        for (PremiumTopping topping : extraPremiumToppings) {
            price += topping == PremiumTopping.AMERICAN_CHEESE || topping == PremiumTopping.PROVOLONE ||
                    topping == PremiumTopping.CHEDDAR || topping == PremiumTopping.SWISS
                    ? size == SandwichSize.SMALL ? 0.30 : size == SandwichSize.MEDIUM ? 0.60 : 0.90
                    : size == SandwichSize.SMALL ? 0.50 : size == SandwichSize.MEDIUM ? 1.00 : 1.50;
        }

        // Add price for toasting
        price += toasted ? 0.50 : 0.0; // Extra cost for toasting is $0.50

        return price;
    }

    @Override
    public String toString() {
        return size + " " + breadType + " Sandwich, " +
                "Toasted: " + toasted +
                ", Premium Toppings: " + premiumToppings +
                ", Extra Premium Toppings: " + extraPremiumToppings +
                ", Regular Toppings: " + regularToppings +
                ", Price: $" + calculatePrice();
    }
}

import java.util.Scanner;

public class Screens {
    private Scanner scanner;
    private Order currentOrder;
    private ReceiptsManager receiptsManager;

    public Screens(Scanner scanner) {
        this.scanner = scanner;
        this.receiptsManager = new ReceiptsManager();
    }

    public void displayHomeScreen() {
        while (true) {
            System.out.println("Welcome to DELI-cious!");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    currentOrder = new Order();
                    displayOrderScreen();
                    break;
                case 0:
                    System.out.println("Thank you for visiting DELI-cious! Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void displayOrderScreen() {
        while (true) {
            System.out.println("\nOrder Screen");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayAddSandwichScreen();
                    break;
                case 2:
                    displayAddDrinkScreen();
                    break;
                case 3:
                    displayAddChipScreen();
                    break;
                case 4:
                    displayCheckoutScreen();
                    return;
                case 0:
                    System.out.println("Order canceled. Returning to Home Screen.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private boolean isCheese(PremiumTopping topping) {
        return topping == PremiumTopping.AMERICAN_CHEESE ||
                topping == PremiumTopping.PROVOLONE ||
                topping == PremiumTopping.CHEDDAR ||
                topping == PremiumTopping.SWISS;
    }

    public void displayAddSandwichScreen() {
        System.out.println("\nCreate Your Sandwich");

        // Choose bread
        System.out.println("Choose your bread:");
        for (BreadType bread : BreadType.values()) {
            System.out.println(bread.ordinal() + 1 + ") " + bread);
        }
        int breadChoice = scanner.nextInt() - 1;
        scanner.nextLine();
        BreadType breadType = BreadType.values()[breadChoice];

        // Choose size
        System.out.println("Choose your sandwich size:");
        for (SandwichSize size : SandwichSize.values()) {
            System.out.println(size.ordinal() + 1 + ") " + size + " - $" + size.getBasePrice());
        }
        int sizeChoice = scanner.nextInt() - 1;
        scanner.nextLine();
        SandwichSize sandwichSize = SandwichSize.values()[sizeChoice];

        Sandwich sandwich = new Sandwich(sandwichSize, breadType);

        // Add one meat
        System.out.println("Choose one type of meat (type the number):");
        for (PremiumTopping meat : PremiumTopping.values()) {
            if (!isCheese(meat)) { // Only display meats
                System.out.println(meat.ordinal() + 1 + ") " + meat);
            }
        }
        int meatChoice = scanner.nextInt() - 1;
        scanner.nextLine();
        PremiumTopping selectedMeat = PremiumTopping.values()[meatChoice];
        if (!isCheese(selectedMeat)) {
            sandwich.addPremiumTopping(selectedMeat);

            // Ask about extra meat
            System.out.print("Would you like extra " + selectedMeat + "? (1 for yes, 0 for no): ");
            if (scanner.nextInt() == 1) {
                sandwich.addExtraPremiumTopping(selectedMeat);
            }
            scanner.nextLine(); // Consume newline
        } else {
            System.out.println("Invalid selection. Meat selection skipped.");
        }

        // Add one cheese
        System.out.println("Choose one type of cheese (type the number):");
        for (PremiumTopping cheese : PremiumTopping.values()) {
            if (isCheese(cheese)) { // Only display cheeses
                System.out.println(cheese.ordinal() + 1 + ") " + cheese);
            }
        }
        int cheeseChoice = scanner.nextInt() - 1;
        scanner.nextLine();
        PremiumTopping selectedCheese = PremiumTopping.values()[cheeseChoice];
        if (isCheese(selectedCheese)) {
            sandwich.addPremiumTopping(selectedCheese);

            // Ask about extra cheese
            System.out.print("Would you like extra " + selectedCheese + "? (1 for yes, 0 for no): ");
            if (scanner.nextInt() == 1) {
                sandwich.addExtraPremiumTopping(selectedCheese);
            }
            scanner.nextLine(); // Consume newline
        } else {
            System.out.println("Invalid selection. Cheese selection skipped.");
        }

        // Add regular toppings
        System.out.println("Choose your regular toppings (type the number to select, 0 to finish):");
        for (RegularTopping topping : RegularTopping.values()) {
            System.out.println(topping.ordinal() + 1 + ") " + topping);
        }
        while (true) {
            int toppingChoice = scanner.nextInt() - 1;
            if (toppingChoice == -1) break; // 0 means finish
            RegularTopping topping = RegularTopping.values()[toppingChoice];
            sandwich.addRegularTopping(topping);
        }
        scanner.nextLine(); // Consume newline

        // Toasted
        System.out.print("Would you like the sandwich toasted? (yes/no): ");
        sandwich.setToasted(scanner.nextLine().equalsIgnoreCase("yes"));

        currentOrder.addItem(sandwich);
        System.out.println("Sandwich added to your order.");
    }


    public void displayAddDrinkScreen() {
        System.out.println("\nChoose your drink size:");
        for (DrinkSize size : DrinkSize.values()) {
            System.out.println(size.ordinal() + 1 + ") " + size + " - $" + size.getPrice());
        }
        int choice = scanner.nextInt() - 1;
        scanner.nextLine();
        DrinkSize size = DrinkSize.values()[choice];

        Drink drink = new Drink(size);
        currentOrder.addItem(drink);
        System.out.println(size + " drink added to your order.");
    }

    public void displayAddChipScreen() {
        System.out.println("\nChoose your chip flavor:");
        for (ChipFlavor flavor : ChipFlavor.values()) {
            System.out.println(flavor.ordinal() + 1 + ") " + flavor);
        }
        int choice = scanner.nextInt() - 1;
        scanner.nextLine();
        ChipFlavor flavor = ChipFlavor.values()[choice];

        Chips chips = new Chips(flavor);
        currentOrder.addItem(chips);
        System.out.println(flavor + " chips added to your order.");
    }

    public void displayCheckoutScreen() {
        System.out.println("\nCheckout");
        System.out.println(currentOrder);

        System.out.print("Confirm your order? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            receiptsManager.saveReceipt(currentOrder);
            System.out.println("Order completed. Returning to Home Screen.");
        } else {
            System.out.println("Order canceled. Returning to Home Screen.");
        }
    }
}
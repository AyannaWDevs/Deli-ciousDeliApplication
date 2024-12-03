import java.util.ArrayList;
import java.util.List;
public class Order {
    private List<Item> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(Item::calculatePrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder("Order Details:\n");
        for (Item item : items) {
            details.append(item).append("\n");
        }
        details.append("Total Price: $").append(calculateTotal());
        return details.toString();
    }
}

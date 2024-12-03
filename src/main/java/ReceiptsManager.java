import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptsManager {
    public void saveReceipt(Order order) {
        // Define the directory path
        String directoryName = "src/main/resources/receipts"; // Update this if you want a different location
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = directoryName + "/" + timestamp + ".txt";

        // Ensure the receipts directory exists
        File directory = new File(directoryName);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Receipts directory created: " + directory.getAbsolutePath());
            } else {
                System.err.println("Failed to create receipts directory.");
                return;
            }
        }

        // Prepare receipt content
        StringBuilder receiptContent = new StringBuilder();
        String orderDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        receiptContent.append("Order Date & Time: ").append(orderDateTime).append("\n\n");
        receiptContent.append(order.toString()); // Append the order details

        // Write the receipt to the file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(receiptContent.toString());
            System.out.println("Receipt successfully saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving receipt: " + e.getMessage());
        }
    }
}

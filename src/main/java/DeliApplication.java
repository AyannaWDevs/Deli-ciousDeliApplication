import java.util.Scanner;
public class DeliApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Screens screens = new Screens(scanner);
        screens.displayHomeScreen();
    }
}

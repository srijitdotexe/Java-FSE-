import java.util.Scanner;

public class StrategyPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select payment method (1 for Credit Card, 2 for PayPal):");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        PaymentStrategy paymentStrategy = null;
        switch (choice) {
            case 1:
                System.out.println("Enter credit card number:");
                String cardNumber = scanner.nextLine();
                System.out.println("Enter card holder name:");
                String cardHolderName = scanner.nextLine();
                paymentStrategy = new CreditCardPayment(cardNumber, cardHolderName);
                break;
            case 2:
                System.out.println("Enter PayPal email:");
                String email = scanner.nextLine();
                paymentStrategy = new PayPalPayment(email);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        PaymentContext paymentContext = new PaymentContext(paymentStrategy);

        System.out.println("Enter amount to be paid:");
        double amount = scanner.nextDouble();

        paymentContext.executePayment(amount);

        scanner.close();
    }
}
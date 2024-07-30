public class AdapterPatternTest {
    public static void main(String[] args) {
        PayPalPayment payPalPayment = new PayPalPayment();
        StripePayment stripePayment = new StripePayment();
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPalPayment);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripePayment);
        System.out.println("Testing PayPal Adapter:");
        payPalAdapter.processPayment(100.0);

        System.out.println("\nTesting Stripe Adapter:");
        stripeAdapter.processPayment(200.0);
    }
}
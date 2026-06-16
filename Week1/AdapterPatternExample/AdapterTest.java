public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        paypal.processPayment(100.00);

        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        stripe.processPayment(200.00);
    }
}
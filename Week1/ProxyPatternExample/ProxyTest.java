public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("photo.jpg");

        // First call - loads from server
        System.out.println("First call:");
        image.display();

        // Second call - uses cache, no reload
        System.out.println("\nSecond call:");
        image.display();
    }
}
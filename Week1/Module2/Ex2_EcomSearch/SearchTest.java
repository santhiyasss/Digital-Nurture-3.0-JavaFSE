public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Phone", "Electronics"),
            new Product(103, "Shirt", "Clothing"),
            new Product(104, "Book", "Education"),
            new Product(105, "Headphones", "Electronics")
        };
        // Already sorted by productId for binary search

        System.out.println("Linear Search for ID 103: " + SearchAlgorithms.linearSearch(products, 103));
        System.out.println("Binary Search for ID 105: " + SearchAlgorithms.binarySearch(products, 105));
        System.out.println("Binary Search for ID 999: " + SearchAlgorithms.binarySearch(products, 999));
    }
}
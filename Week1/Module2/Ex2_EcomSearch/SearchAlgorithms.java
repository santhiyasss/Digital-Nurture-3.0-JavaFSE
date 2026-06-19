public class SearchAlgorithms {

    // Linear Search — O(n)
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.productId == targetId) return p;
        }
        return null;
    }

    // Binary Search — O(log n) — array must be sorted by productId
    public static Product binarySearch(Product[] products, int targetId) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productId == targetId) return products[mid];
            else if (products[mid].productId < targetId) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }
}
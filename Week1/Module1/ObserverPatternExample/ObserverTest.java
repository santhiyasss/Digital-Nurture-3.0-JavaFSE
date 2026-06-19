public class ObserverTest {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp("MyPhone");
        Observer web = new WebApp("MyBrowser");

        market.register(mobile);
        market.register(web);

        System.out.println("--- Price Update 1 ---");
        market.setStockPrice("APPLE", 175.50);

        System.out.println("\n--- Price Update 2 ---");
        market.setStockPrice("GOOGLE", 140.75);

        System.out.println("\n--- Deregistering WebApp ---");
        market.deregister(web);
        market.setStockPrice("TESLA", 250.00);
    }
}
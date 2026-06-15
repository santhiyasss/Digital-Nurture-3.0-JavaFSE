public class ForecastTest {
    public static void main(String[] args) {

        double presentValue = 100000;  // Initial investment
        double growthRate = 0.08;      // 8% annual growth
        int years = 5;

        // Recursive
        double futureRecursive = FinancialForecast.futureValueRecursive(presentValue, growthRate, years);
        System.out.printf("Recursive  - Future Value after %d years: %.2f%n", years, futureRecursive);

        // Memoized
        double[] memo = new double[years + 1];
        double futureMemo = FinancialForecast.futureValueMemo(presentValue, growthRate, years, memo);
        System.out.printf("Memoized   - Future Value after %d years: %.2f%n", years, futureMemo);

        // Show year by year breakdown
        System.out.println("\n--- Year by Year Breakdown ---");
        for (int i = 1; i <= years; i++) {
            double value = FinancialForecast.futureValueRecursive(presentValue, growthRate, i);
            System.out.printf("Year %d: %.2f%n", i, value);
        }
    }
}
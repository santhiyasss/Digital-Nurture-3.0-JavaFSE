public class FinancialForecast {

    // Simple Recursive approach — O(n)
    public static double futureValueRecursive(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return futureValueRecursive(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Optimized with Memoization — avoids repeated computation
    public static double futureValueMemo(double presentValue, double growthRate, int years, double[] memo) {
        if (years == 0) {
            return presentValue;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = futureValueMemo(presentValue, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }
}
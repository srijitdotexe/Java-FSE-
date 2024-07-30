import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FinancialForecasting {
    private static Map<Integer, Double> memo = new HashMap<>();
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        double futureValue = calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
        memo.put(years, futureValue);
        
        return futureValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the present value: ");
        double presentValue = scanner.nextDouble();
        System.out.print("Enter the annual growth rate (as a percentage): ");
        double growthRatePercentage = scanner.nextDouble();
        double growthRate = growthRatePercentage / 100;
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years: %.2f%n", years, futureValue);
        
        scanner.close();
    }
}

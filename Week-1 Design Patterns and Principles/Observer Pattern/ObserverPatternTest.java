import java.util.Scanner;

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter stock symbol (or 'exit' to quit):");
            String stockSymbol = scanner.nextLine();
            if (stockSymbol.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Enter stock price:");
            double stockPrice = scanner.nextDouble();
            scanner.nextLine();
            stockMarket.setStockData(stockSymbol, stockPrice);
        }

        scanner.close();
    }
}

import java.util.*;

class Stock {
    String sym;
    double price;

    Stock(String sym, double price) {
        this.sym = sym;
        this.price = price;
    }
}

class Portfolio {
    HashMap<String, Integer> stocks = new HashMap<>();
    double balance = 10000.0;

    void buyStock(String sym, int qty, double price) {
        if (balance >= qty * price) {
            balance -= qty * price;
            stocks.put(sym, stocks.getOrDefault(sym, 0) + qty);
            System.out.println("Bought " + qty + " of " + sym);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    void sellStock(String sym, int qty, double price) {
        if (stocks.containsKey(sym) && stocks.get(sym) >= qty) {
            stocks.put(sym, stocks.get(sym) - qty);
            balance += qty * price;
            System.out.println("Sold " + qty + " of " + sym);
        } else {
            System.out.println("Not enough shares to sell");
        }
    }

    void showPortfolio() {
        System.out.println("Portfolio:");
        for (Map.Entry<String, Integer> entry : stocks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " shares");
        }
        System.out.println("Balance: $" + balance);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Portfolio pf = new Portfolio();
        HashMap<String, Stock> marketData = new HashMap<>();

        marketData.put("AAPL", new Stock("AAPL", 150.0));
        marketData.put("GOOG", new Stock("GOOG", 2800.0));
        marketData.put("TSLA", new Stock("TSLA", 700.0));

        while (true) {
            System.out.println("1. Buy Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. Show Portfolio");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 4) {
                break;
            }

            switch (ch) {
                case 1:
                    System.out.print("Enter stock symbol: ");
                    String bsym = sc.next();
                    if (marketData.containsKey(bsym)) {
                        System.out.print("Enter quantity: ");
                        int bqty = sc.nextInt();
                        pf.buyStock(bsym, bqty, marketData.get(bsym).price);
                    } else {
                        System.out.println("Stock not found");
                    }
                    break;
                case 2:
                    System.out.print("Enter stock symbol: ");
                    String ssym = sc.next();
                    if (marketData.containsKey(ssym)) {
                        System.out.print("Enter quantity: ");
                        int sqty = sc.nextInt();
                        pf.sellStock(ssym, sqty, marketData.get(ssym).price);
                    } else {
                        System.out.println("Stock not found");
                    }
                    break;
                case 3:
                    pf.showPortfolio();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
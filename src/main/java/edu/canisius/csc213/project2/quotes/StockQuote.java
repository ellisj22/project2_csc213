package edu.canisius.csc213.project2.quotes;

public class StockQuote {

    private String symbol;
    public String getSymbol() {
        return symbol;
    }

    private double closePrice;
    public double getClosePrice() {
        return closePrice;
    }

    private double highestPrice;
    public double getHighestPrice() {
        return highestPrice;
    }

    private double lowestPrice;
    public double getLowestPrice() {
        return lowestPrice;
    }

    private int numberOfTransactions;
    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    private double openPrice;
    public double getOpenPrice() {
        return openPrice;
    }

    private long timestamp;
    public long getTimestamp() {
        return timestamp;
    }

    private double tradingVolume;

    public double getTradingVolume() {
        return tradingVolume;
    }

    public StockQuote(String symbol, double closePrice, double highestPrice, double lowestPrice, int numberOfTransactions, double openPrice, long timestamp, double tradingVolume) {
        this.symbol = symbol;
        this.closePrice = closePrice;
        this.highestPrice = highestPrice;
        this.lowestPrice = lowestPrice;
        this.numberOfTransactions = numberOfTransactions;
        this.openPrice = openPrice;
        this.timestamp = timestamp;
        this.tradingVolume = tradingVolume;
    }

    public String prettyPrint() {
        return "Symbol: " + symbol + "\n" +
               "Close Price: " + closePrice + "\n" +
               "Highest Price: " + highestPrice + "\n" +
               "Lowest Price: " + lowestPrice + "\n" +
               "Number of Transactions: " + numberOfTransactions + "\n" +
               "Open Price: " + openPrice + "\n" +
               "Trading Volume: " + tradingVolume + "\n";
    }

}

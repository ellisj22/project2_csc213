package edu.canisius.csc213.project2.quotes;

public class StockQuote {

    private String symbol;
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    private double closePrice;
    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public double getClosePrice() {
        return closePrice;
    }

    private double highestPrice;
    public void setHighestPrice(double highestPrice) {
        this.highestPrice = highestPrice;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    private double lowestPrice;
    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    private int numberOfTransactions;
    public void setNumberOfTransactions(int numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    private double openPrice;
    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    private long timestamp;
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    private double tradingVolume;

    public void setTradingVolume(double tradingVolume) {
        this.tradingVolume = tradingVolume;
    }

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
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(symbol).append("\n");
        sb.append("Close Price: ").append(closePrice).append("\n");
        sb.append("Highest Price: ").append(highestPrice).append("\n");
        sb.append("Lowest Price: ").append(lowestPrice).append("\n");
        sb.append("Number of Transactions: ").append(numberOfTransactions).append("\n");
        sb.append("Open Price: ").append(openPrice).append("\n");
        sb.append("Trading Volume: ").append(tradingVolume).append("\n");
        return sb.toString();
    }

}

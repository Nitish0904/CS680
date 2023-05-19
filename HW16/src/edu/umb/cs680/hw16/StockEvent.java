package edu.umb.cs680.hw16;

public class StockEvent {

    protected String ticker;
    protected double quote;

    public StockEvent(String ticker, double quote){
        this.ticker=ticker;
        this.quote=quote;
    }

    public double getQuote() {
        return quote;
    }

    public String getTicker() {
        return ticker;
    }
}

package edu.umb.cs680.hw16;


import java.util.HashMap;

public class Linechartobserver implements Observer<StockEvent> {
    private HashMap<String,Double> LinechartMap=new HashMap<>();

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        LinechartMap.put(event.getTicker(), event.getQuote());
        System.out.println("Line Chart Printing");
        System.out.println("Ticker:"+event.getTicker());
        System.out.println("Quote:"+event.getQuote());
    }

    public HashMap<String, Double> getLinechartMap() {
        return LinechartMap;
    }
}


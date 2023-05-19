package edu.umb.cs680.hw16;

import java.util.HashMap;

public class TableObserver implements Observer<StockEvent>{

    private HashMap<String,Double> TableMap = new HashMap<>();

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        TableMap.put(event.getTicker(), event.getQuote());
        System.out.println("Table Printing");
        System.out.println("Ticker:"+event.getTicker());
        System.out.println("Quote:"+event.getQuote());
    }

    public HashMap<String, Double> getTableMap() {
        return TableMap;
    }
}

package edu.umb.cs680.hw16;

import java.util.HashMap;

public class StockQuoteObservable extends Observable {
    private HashMap<String,Double> hashMap=new HashMap<>();

    public StockQuoteObservable(){
        this.hashMap=new HashMap<>();
    }

    public  void ChangeQuote(String s,Double d){
        hashMap.put(s,d);
        notifyObservers(new StockEvent(s,d));
    }

    public HashMap<String, Double> getHashMap() {
        return hashMap;
    }
}

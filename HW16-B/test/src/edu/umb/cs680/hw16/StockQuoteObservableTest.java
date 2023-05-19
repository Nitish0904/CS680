package edu.umb.cs680.hw16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;


class StockQuoteObservableTest {
    private HashMap<String,Double> LinechartMap=new HashMap<>();
    private HashMap<String,Double> ThreeDMap=new HashMap<>();
    private HashMap<String,Double> TableMap=new HashMap<>();


    @Test
    void Test1(){
        Observer<StockEvent> tableObserver=(sender, event) -> {
            TableMap.put(event.getTicker(), event.getQuote());
            System.out.println("Table Printing");
            System.out.println("Ticker is\n  " + event.getTicker());
            System.out.println("Quote is\n " + event.getQuote());
        };
        Observer<StockEvent> linechartobserver=(sender, event) -> {
            LinechartMap.put(event.getTicker(), event.getQuote());
            System.out.println("Line Chart Printing");
            System.out.println("Ticker is\n  " + event.getTicker());
            System.out.println("Quote is\n " + event.getQuote());
        };
        Observer<StockEvent> threeDObserver=(sender, event) -> {
            ThreeDMap.put(event.getTicker(), event.getQuote());
            System.out.println("Three DO Printing");
            System.out.println("Ticker is\n  " + event.getTicker());
            System.out.println("Quote is\n " + event.getQuote());
        };


        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();
        stockQuoteObservable.addObserver(tableObserver);
        stockQuoteObservable.addObserver(linechartobserver);
        stockQuoteObservable.addObserver(threeDObserver);
        stockQuoteObservable.ChangeQuote("NITI", 3124.0);
        Assertions.assertEquals(3,stockQuoteObservable.countObservers());
    }

    @Test
    void Test2(){
        Observer<StockEvent> tableObserver=(sender, event) -> {
            TableMap.put(event.getTicker(), event.getQuote());
            System.out.println("Table Printing");
            System.out.println("Ticker is\n  " + event.getTicker());
            System.out.println("Quote is\n " + event.getQuote());
        };
        Observer<StockEvent> linechartobserver=(sender, event) -> {
            LinechartMap.put(event.getTicker(), event.getQuote());
            System.out.println("Line Chart Printing");
            System.out.println("Ticker is\n  " + event.getTicker());
            System.out.println("Quote is\n " + event.getQuote());
        };
        Observer<StockEvent> threeDObserver=(sender, event) -> {
            ThreeDMap.put(event.getTicker(), event.getQuote());
            System.out.println("Three DO Printing");
            System.out.println("Ticker is\n  " + event.getTicker());
            System.out.println("Quote is\n " + event.getQuote());
        };

        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();
        stockQuoteObservable.addObserver(threeDObserver);
        Assertions.assertEquals(1,stockQuoteObservable.countObservers());
        stockQuoteObservable.clearObservers();
        Assertions.assertEquals(0,stockQuoteObservable.countObservers());

    }

    @Test
    void test3(){
        Observer<StockEvent> tableObserver=(sender, event) -> {
            TableMap.put(event.getTicker(), event.getQuote());
            System.out.println("Table Printing");
            System.out.println("Ticker is\n  " + event.getTicker());
            System.out.println("Quote is\n " + event.getQuote());
        };
        Observer<StockEvent> linechartobserver=(sender, event) -> {
            LinechartMap.put(event.getTicker(), event.getQuote());
            System.out.println("Line Chart Printing");
            System.out.println("Ticker is\n  " + event.getTicker());
            System.out.println("Quote is\n " + event.getQuote());
        };
        Observer<StockEvent> threeDObserver=(sender, event) -> {
            ThreeDMap.put(event.getTicker(), event.getQuote());
            System.out.println("Three DO Printing");
            System.out.println("Ticker is\n  " + event.getTicker());
            System.out.println("Quote is\n " + event.getQuote());
        };

        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();

        stockQuoteObservable.addObserver(tableObserver);
        stockQuoteObservable.addObserver(linechartobserver);

        stockQuoteObservable.addObserver(threeDObserver);
        Assertions.assertEquals(3,stockQuoteObservable.countObservers());
        stockQuoteObservable.removeObserver(tableObserver);
        Assertions.assertEquals(2,stockQuoteObservable.countObservers());
    }

    @Test
    void test(){
        Observer<StockEvent> tableObserver=(sender, event) -> {
            TableMap.put(event.getTicker(), event.getQuote());
            System.out.println("Table Printing");
            System.out.println("Ticker is\n  " + event.getTicker());
            System.out.println("Quote is\n " + event.getQuote());
        };
        Observer<StockEvent> linechartobserver=(sender, event) -> {
            LinechartMap.put(event.getTicker(), event.getQuote());
            System.out.println("Line Chart Printing");
            System.out.println("Ticker is\n  " + event.getTicker());
            System.out.println("Quote is\n " + event.getQuote());
        };
        Observer<StockEvent> threeDObserver=(sender, event) -> {
            ThreeDMap.put(event.getTicker(), event.getQuote());
            System.out.println("Three DO Printing");
            System.out.println("Ticker is\n  " + event.getTicker());
            System.out.println("Quote is\n " + event.getQuote());
        };

        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();

        stockQuoteObservable.addObserver(tableObserver);
        stockQuoteObservable.addObserver(linechartobserver);
        stockQuoteObservable.addObserver(threeDObserver);
        stockQuoteObservable.ChangeQuote("NITI", 3124.0);
        Assertions.assertEquals(LinechartMap,stockQuoteObservable.getHashMap());
        Assertions.assertEquals(TableMap,stockQuoteObservable.getHashMap());
        Assertions.assertEquals(ThreeDMap,stockQuoteObservable.getHashMap());
    }
}
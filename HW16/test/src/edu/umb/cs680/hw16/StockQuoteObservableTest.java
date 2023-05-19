package edu.umb.cs680.hw16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;


class StockQuoteObservableTest {


    @Test
    void Test1(){
        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();
        Linechartobserver linechartobserver =new Linechartobserver();
        TableObserver tableObserver =new TableObserver();
        stockQuoteObservable.addObserver(tableObserver);
        stockQuoteObservable.addObserver(linechartobserver);
        ThreeDObserver threeDObserver =new ThreeDObserver();
        stockQuoteObservable.addObserver(threeDObserver);
        stockQuoteObservable.ChangeQuote("NITI", 3124.0);
        Assertions.assertEquals(3,stockQuoteObservable.countObservers());
    }

    @Test
    void Test2(){
        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();
        ThreeDObserver threeDObserver =new ThreeDObserver();
        stockQuoteObservable.addObserver(threeDObserver);
        Assertions.assertEquals(1,stockQuoteObservable.countObservers());
        stockQuoteObservable.clearObservers();
        Assertions.assertEquals(0,stockQuoteObservable.countObservers());

    }

    @Test
    void test3(){
        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();
        Linechartobserver linechartobserver =new Linechartobserver();
        TableObserver tableObserver =new TableObserver();
        stockQuoteObservable.addObserver(tableObserver);
        stockQuoteObservable.addObserver(linechartobserver);
        ThreeDObserver threeDObserver =new ThreeDObserver();
        stockQuoteObservable.addObserver(threeDObserver);
        Assertions.assertEquals(3,stockQuoteObservable.countObservers());
        stockQuoteObservable.removeObserver(tableObserver);
        Assertions.assertEquals(2,stockQuoteObservable.countObservers());
    }

    @Test
    void test(){
        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();
        Linechartobserver linechartobserver =new Linechartobserver();
        TableObserver tableObserver =new TableObserver();
        stockQuoteObservable.addObserver(tableObserver);
        stockQuoteObservable.addObserver(linechartobserver);
        ThreeDObserver threeDObserver =new ThreeDObserver();
        stockQuoteObservable.addObserver(threeDObserver);
        stockQuoteObservable.ChangeQuote("NITI", 3124.0);
        Assertions.assertEquals(linechartobserver.getLinechartMap(),stockQuoteObservable.getHashMap());
        Assertions.assertEquals(tableObserver.getTableMap(),stockQuoteObservable.getHashMap());
        Assertions.assertEquals(threeDObserver.getThreeDMap(),stockQuoteObservable.getHashMap());
    }
}
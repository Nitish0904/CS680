package edu.umb.cs680.hw09.ModelABC;

public class Printer {

    private Printer(){

    }

    private static Printer instance=null;

    public static Printer getInstance(){
        if (instance==null){
            instance=new Printer();
        }
        return instance;
    }

    public void print(){
        System.out.println("Printing");
    }
}

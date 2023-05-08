package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.PrintingFramework.Command;

public class PrintJob implements Command {

    private Printer p;
    public PrintJob(){
        p=Printer.getInstance();
    }
    @Override
    public void execute() {
        p.print();
    }
}

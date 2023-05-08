package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.PrintingFramework.Command;
import edu.umb.cs680.hw09.hw04.EncryptedString;
import edu.umb.cs680.hw09.hw04.LoggedOut;
import edu.umb.cs680.hw09.hw04.SecurityContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {

    @Test
    public void TestPrinting(){
        SecurityContext sc=new SecurityContext(new EncryptedString("hello"),"user");
        PrintJobExecutor pe=new PrintJobExecutor();
        Command job=new PrintJob();
        pe.doAuthentication(sc,new EncryptedString("hello"));
        pe.doPrint(sc,job);
        assertTrue(!(sc.getState() instanceof LoggedOut));
    }

    @Test
    public void TestPrinter(){
       Printer p= Printer.getInstance();
       p.print();
       assertTrue(p instanceof Printer);
    }

    @Test
    public void TestPrintJob(){
       PrintJob p=new PrintJob();
       p.execute();
       assertTrue(p instanceof PrintJob);
    }
}
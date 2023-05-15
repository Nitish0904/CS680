package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.PrintingFramework.Command;
import edu.umb.cs680.hw09.hw04.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {

    SecurityContext scx=new SecurityContext(new EncryptedString("hello"),"user");

    @Test
    public void TestPrinting(){
        PrintJobExecutor pe=new PrintJobExecutor();
        Command job=new PrintJob();
        pe.doAuthentication(scx,new EncryptedString("hello"));
        pe.doPrint(scx,job);
        assertTrue(!(scx.getState() instanceof LoggedOut));
    }

    @Test
    public void TestPrinter(){
       Printer p= Printer.getInstance();
       p.print();
       assertTrue(p instanceof Printer);
    }

    @Test
    public void TestPrintJob(){
       Command p=new PrintJob();
       p.execute();
       assertTrue(p instanceof PrintJob);
    }

    @Test
    public void TestAuthentication(){

        boolean actual= Authenticator.authenticate(new EncryptedString("hello"),scx);
        boolean expected=true;
        assertEquals(expected,actual);
    }
    @Test
    public void TestLoginWhenLoggedOut(){
        scx.logout();
        scx.login(new EncryptedString("hello"));
        assertTrue(scx.getState() instanceof LoggedIn);
    }
    @Test
    public void TestLogoutWhenLoggedIn(){
        scx.login(new EncryptedString("hello"));
        scx.logout();
        assertTrue(scx.getState() instanceof LoggedOut);
    }

    @Test
    public void TestLoginWhenLoggedIn(){
        scx.login(new EncryptedString("hello"));
        assertTrue(scx.getState() instanceof LoggedIn);
        scx.login(new EncryptedString("hello"));
        assertTrue(scx.getState() instanceof LoggedIn);
    }

    @Test
    public void TestAuthenticationFailException(){

        try{
            PrintJobExecutor pe=new PrintJobExecutor();
            scx.login(new EncryptedString("hi"));
            Command job=new PrintJob();
            pe.doAuthentication(scx,new EncryptedString("hello"));
            pe.doPrint(scx,job);
            fail("Failed to Authenticate");
        }
        catch (Exception e){
            String expected="Incorrect Password";
            assertEquals(expected,e.getMessage());
        }
    }

}
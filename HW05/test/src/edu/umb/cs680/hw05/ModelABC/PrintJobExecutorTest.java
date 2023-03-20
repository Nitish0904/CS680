package edu.umb.cs680.hw05.ModelABC;

import edu.umb.cs680.hw04.EncryptedString;
import edu.umb.cs680.hw04.LoggedOut;
import edu.umb.cs680.hw04.SecurityContext;
import edu.umb.cs680.hw05.PrintingFramework.PrintJob;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {

    //Positive Test for doPrint
    @Test
    public void TestPrinting(){
        SecurityContext sc=new SecurityContext(new EncryptedString("hello"),"user");
        PrintJobExecutor pe=new PrintJobExecutor();
        pe.doAuthentication(sc,new EncryptedString("hello"));
        pe.doPrint(sc,new PrintJob());
        assertTrue(!(sc.getState() instanceof LoggedOut));
    }

    //Positive Test for doAuthentication
    @Test
    public void TestAuthentication(){
        SecurityContext sc=new SecurityContext(new EncryptedString("hello"),"user");
        PrintJobExecutor pe=new PrintJobExecutor();
        pe.doAuthentication(sc,new EncryptedString("hello"));
        pe.doPrint(sc,new PrintJob());
        assertTrue(!(sc.getState() instanceof LoggedOut));
    }

    //Negative Test for doPrint
    @Test
    public void TestExceptionWhenLoggedout(){
        SecurityContext sc=new SecurityContext(new EncryptedString("hello"),"user");
        PrintJobExecutor pe=new PrintJobExecutor();
        try{
            sc.logout();
            pe.doPrint(sc,new PrintJob());
        }catch(Exception e){
            assertTrue(sc.getState() instanceof LoggedOut);
            assertEquals("User Loggedout",e.getMessage());
        }
    }
    
    //Negative Test for doAuthentication
    @Test
    public void TestAuthenticationFailureException(){
        SecurityContext sc=new SecurityContext(new EncryptedString("hello"),"user");
        PrintJobExecutor pe=new PrintJobExecutor();
        try{
            pe.doAuthentication(sc,new EncryptedString("hi"));
            pe.doPrint(sc,new PrintJob());
        }catch(Exception e){
            assertTrue(sc.getState() instanceof LoggedOut);
            assertEquals("Failed to Authenticate",e.getMessage());
        }
    }
}
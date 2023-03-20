package edu.umb.cs680.hw05.ModelXYZ;

import edu.umb.cs680.hw04.EncryptedString;
import edu.umb.cs680.hw04.SecurityContext;
import edu.umb.cs680.hw05.PrintingFramework.PrintJob;
import org.junit.jupiter.api.Test;

class PrintJobExecutorTest {
    @Test
    public void PrintingWithModelXYZ(){
        PrintJobExecutor px= new PrintJobExecutor();
        px.execute(new SecurityContext(new EncryptedString("hello"),"user"),new PrintJob(),new EncryptedString("hello"));
    }

}
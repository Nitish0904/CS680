package edu.umb.cs680.hw05.ModelABC;

import edu.umb.cs680.hw04.*;
import edu.umb.cs680.hw05.PrintingFramework.PrintJob;

public class PrintJobExecutor extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecutor {
    @Override
    protected void doAuthentication(SecurityContext sc, EncryptedString password) {
            if(!(Authenticator.authenticate(password,sc))){
                throw new RuntimeException("Failed to Authenticate");
            }
            else{
                sc.login(password);
            }
    }

    @Override
    protected void doAccessControl() { }

    @Override
    protected void doPrint(SecurityContext sc, PrintJob pjob) {
        if(!(sc.getState() instanceof LoggedIn)){
           throw new RuntimeException("User Loggedout");
        }
        else{
            pjob.executePrinting("ModelABC");
        }
    }

    @Override
    protected void doErrorHandling() { }
}

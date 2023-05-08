package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.PrintingFramework.Command;
import edu.umb.cs680.hw09.hw04.*;


import java.awt.*;

public class PrintJobExecutor extends edu.umb.cs680.hw09.PrintingFramework.PrintJobExecutor {
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
    protected void doPrint(SecurityContext sc, Command pjob) {
        if(!(sc.getState() instanceof LoggedIn)){
           throw new RuntimeException("User Loggedout");
        }
        else{
            pjob.execute();
        }
    }

    @Override
    protected void doErrorHandling() { }
}

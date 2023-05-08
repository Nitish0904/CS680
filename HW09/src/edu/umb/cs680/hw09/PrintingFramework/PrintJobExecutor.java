package edu.umb.cs680.hw09.PrintingFramework;

import edu.umb.cs680.hw09.hw04.EncryptedString;
import edu.umb.cs680.hw09.hw04.SecurityContext;

import java.awt.*;

public abstract class PrintJobExecutor {
    public void execute(SecurityContext sc, Command pjob, EncryptedString password){
        doAuthentication(sc,password);
        doAccessControl();
        doPrint(sc,pjob);
        doErrorHandling();
    }

    protected abstract void doAuthentication(SecurityContext sc, EncryptedString password);

    protected abstract void doAccessControl();

    protected abstract void doPrint(SecurityContext sc, Command pjob);

    protected abstract void doErrorHandling();
}

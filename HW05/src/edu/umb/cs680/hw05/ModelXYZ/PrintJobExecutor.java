package edu.umb.cs680.hw05.ModelXYZ;

import edu.umb.cs680.hw04.*;
import edu.umb.cs680.hw05.PrintingFramework.PrintJob;

public class PrintJobExecutor extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecutor {

    @Override
    protected void doAuthentication(SecurityContext sc, EncryptedString password) { }

    @Override
    protected void doAccessControl() { }

    @Override
    protected void doPrint(SecurityContext sc, PrintJob pjob) {
        pjob.executePrinting("ModelXYZ");

    }

    @Override
    protected void doErrorHandling() { }
}

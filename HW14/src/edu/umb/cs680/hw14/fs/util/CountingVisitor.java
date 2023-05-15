package edu.umb.cs680.hw14.fs.util;

import edu.umb.cs680.hw14.fs.Directory;
import edu.umb.cs680.hw14.fs.FSVisitor;
import edu.umb.cs680.hw14.fs.File;
import edu.umb.cs680.hw14.fs.Link;

public class CountingVisitor implements FSVisitor {
    public int cntlk = 0;
    public int cntdir = 0;
    public int cntfl = 0;

    @Override
    public void visit(Link lk) {
        cntlk++;
    }

    @Override
    public void visit(Directory dir) {
        cntdir++;
    }

    @Override
    public void visit(File fl) {
        cntfl++;
    }

    public int getLinkNumber() {
        return cntlk;
    }

    public int getDirNumber() {
        return cntdir;
    }

    public int getflNumber() {
        return cntfl; }
}

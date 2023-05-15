package edu.umb.cs680.hw12.fs.util;

import edu.umb.cs680.hw12.fs.Directory;
import edu.umb.cs680.hw12.fs.FSVisitor;
import edu.umb.cs680.hw12.fs.File;
import edu.umb.cs680.hw12.fs.Link;

import java.util.ArrayList;

public class FileSearchVisitor implements FSVisitor {

    private String flnm;

    public FileSearchVisitor(String flnm) {
        this.flnm = flnm;
    }

    private ArrayList<File> newfl = new ArrayList<>();

    @Override
    public void visit(Link lk) {
    }

    @Override
    public void visit(Directory dir) {

    }

    @Override
    public void visit(File fl) {
        if (fl.getName().equals(flnm)){newfl.add(fl);}
    }



    public ArrayList<File> getNewfl() {
        return newfl;
    }
}

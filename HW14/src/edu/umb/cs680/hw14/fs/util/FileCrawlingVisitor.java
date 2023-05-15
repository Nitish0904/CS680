package edu.umb.cs680.hw14.fs.util;

import edu.umb.cs680.hw14.fs.Directory;
import edu.umb.cs680.hw14.fs.FSVisitor;
import edu.umb.cs680.hw14.fs.File;
import edu.umb.cs680.hw14.fs.Link;

import java.util.ArrayList;

public class FileCrawlingVisitor implements FSVisitor {
    private ArrayList<File> files = new ArrayList<>();

    @Override
    public void visit(Link lk) {

    }

    @Override
    public void visit(Directory dir) {

    }

    @Override
    public void visit(File fl) {
        files.add(fl);
    }



    public ArrayList<File> getFiles(){
        return files;
    }
}

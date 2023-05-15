package edu.umb.cs680.hw12.fs.util;

import edu.umb.cs680.hw12.fs.Directory;
import edu.umb.cs680.hw12.fs.FSVisitor;
import edu.umb.cs680.hw12.fs.File;
import edu.umb.cs680.hw12.fs.Link;

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

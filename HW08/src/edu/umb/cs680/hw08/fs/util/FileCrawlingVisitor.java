package edu.umb.cs680.hw08.fs.util;

import java.util.ArrayList;
import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.FSVisitor;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.Link;

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

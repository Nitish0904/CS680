package edu.umb.cs680.hw08.fs;

import java.util.LinkedList;

public class FileSystem {
    private static FileSystem thisInstance;
    LinkedList<Directory> rds = new LinkedList<>();


    public static FileSystem getFileSystem(){
        if(thisInstance == null) {
            thisInstance = new FileSystem();
        }
        return thisInstance;
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rds;
    }

    public void appendRootDir(Directory d){
        this.rds.add(d);
    }
}

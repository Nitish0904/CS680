package edu.umb.cs680.hw06;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{


    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }
    private LinkedList<FSElement> cdlist = new LinkedList<>();

    public LinkedList<FSElement> getChildren(){
        return this.cdlist;
    }

    public void appendChild(FSElement child){
        this.cdlist.add(child);
    }

    public int countChildren(){
        return this.cdlist.size();
    }

    public LinkedList<Directory> getSubDirectories(){
        LinkedList<Directory> sdrs = new LinkedList<>();

        for (FSElement checksdrs: this.cdlist){
            if(checksdrs.isDirectory() == true)
                sdrs.add((Directory) checksdrs);
        }
        return sdrs;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> fls = new LinkedList<>();

        for(FSElement checkfls: this.cdlist){
            if(checkfls.isFile() == true)
                fls.add((File) checkfls);
        }
        return fls;
    }

    public int getTotalSize() {
        int fileSum = 0;
        for (File f : getFiles()) {
            fileSum += f.getSize();
        }

        int dirSum = 0;
        for (Directory d : getSubDirectories()) {
            dirSum += d.getTotalSize();
        }

        return fileSum + dirSum + this.getSize();
    }




    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }
}

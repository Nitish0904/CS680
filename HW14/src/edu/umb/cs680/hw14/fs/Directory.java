package edu.umb.cs680.hw14.fs;

import edu.umb.cs680.hw14.comparator.AlphabeticalComparator;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Comparator;

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
        Collections.sort(cdlist, new AlphabeticalComparator());
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

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator) {
        Collections.sort(this.cdlist, comparator);
        return this.cdlist;
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comparator) {
        LinkedList<Directory> subDirectories = getSubDirectories();
        Collections.sort(this.cdlist, comparator);
        return subDirectories;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> comparator) {
        LinkedList<File> files = getFiles();
        Collections.sort(files, comparator);
        return files;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isLink(){
        return false;
    }

    @Override
    public void accept(FSVisitor vst) {
        vst.visit(this);
        for(FSElement fs : cdlist){
            fs.accept(vst);
        }
    }
}

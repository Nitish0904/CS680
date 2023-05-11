package edu.umb.cs680.hw08.fs;

public interface FSVisitor {
    void visit (Link lk);
    void visit (Directory dir);
    void visit (File fl);

}

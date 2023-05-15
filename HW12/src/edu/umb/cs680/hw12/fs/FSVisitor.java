package edu.umb.cs680.hw12.fs;

public interface FSVisitor {
    void visit (Link lk);
    void visit (Directory dir);
    void visit (File fl);

}

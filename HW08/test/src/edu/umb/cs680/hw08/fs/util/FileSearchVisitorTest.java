package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.FileSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSearchVisitorTest {

    public static FileSystem flstem;

    @Test
    void getFilesInFileSystem() {
        flstem = Test_Fixtures.nfs();
        FileSearchVisitor visitor = new FileSearchVisitor("a");
        flstem.getRootDirs().getFirst().accept(visitor);
        assertEquals(visitor.getNewfl().get(0).getName(),"a" );
    }
}
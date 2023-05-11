package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class FileSystemTest {
    private static FileSystem filestm;

    @Test
    public void singletonornot(){
        filestm = Test_Fixtures.nfs();
        FileSystem fs1 = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();
        assertSame(fs1, fs2);
    }

    @Test
    public void getrds(){
        filestm = Test_Fixtures.nfs();
        assertEquals("prjroot", filestm.getRootDirs().getFirst().getName());
    }

    @Test
    public void  apdrd(){
        filestm = Test_Fixtures.nfs();
        Directory newroot = new Directory(null, "newroot", 0, LocalDateTime.now());
        filestm.appendRootDir(newroot);
        assertEquals("newroot", filestm.getRootDirs().getLast().getName());
    }
}

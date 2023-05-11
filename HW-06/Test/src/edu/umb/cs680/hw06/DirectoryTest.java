package edu.umb.cs680.hw06;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest {
    private static FileSystem filestm;

    private String[] dirToStringArray(Directory src) {
        String[] dirInfo = {src.getName(), String.valueOf(src.getSize()), String.valueOf(src.getCreationTime())};
        return dirInfo;
    }

    @Test
    public void verifyDirectoryEqualityRoot() {
        filestm = Test_Fixtures.nfs();
        String[] expected = new String[]{"src", "0", "2021-09-09T10:25"};
        Directory actual = filestm.getRootDirs().getFirst().getSubDirectories().get(0);
        assertArrayEquals(expected, dirToStringArray(actual));

    }

    @Test
    public void isDirornot() {
        filestm = Test_Fixtures.nfs();
        assertTrue(filestm.getRootDirs().getFirst().getSubDirectories().get(0).isDirectory());
    }

    @Test
    public void countcldn() {
        filestm = Test_Fixtures.nfs();
        assertEquals(4, filestm.getRootDirs().getFirst().countChildren());
    }

    @Test
    public void verifyappendchild(){
        filestm = Test_Fixtures.nfs();
        Directory naya = new Directory(null, "naya", 0, LocalDateTime.now());
        Directory chotu = new Directory(naya, "chotu", 0 , LocalDateTime.now());
        naya.appendChild(chotu);
        String expected = chotu.getName();
        assertSame(expected, naya.getSubDirectories().getLast().getName());
    }

    @Test
    public void getsubdirs(){
        filestm = Test_Fixtures.nfs();
        assertEquals(3, filestm.getRootDirs().getFirst().getSubDirectories().size());
    }

    @Test
    public void getfls(){
        filestm = Test_Fixtures.nfs();
        assertEquals(1, filestm.getRootDirs().getFirst().getFiles().size());
    }

    @Test
    public void gettotsz(){
        filestm = Test_Fixtures.nfs();
        assertEquals(225, filestm.getRootDirs().get(0).getTotalSize());
    }
}


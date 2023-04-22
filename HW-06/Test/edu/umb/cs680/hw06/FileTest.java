package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileTest {
    private static FileSystem filestm;

    private String[] fileToStringArray(File x) {
        String[] fileInfo = {x.getName(), String.valueOf(x.getSize()), String.valueOf(x.getCreationTime())};
        return fileInfo;
    }

    @Test
    public void verifyFileEquality() {
        filestm = Test_Fixtures.nfs();
        String[] expected = new String[]{"x", "30", "2021-09-09T10:25"};
        File actual = filestm.getRootDirs().getFirst().getFiles().get(0);
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void checkisdir(){
        filestm = Test_Fixtures.nfs();
        assertFalse(filestm.getRootDirs().getFirst().getSubDirectories().get(0).getChildren().get(0).isDirectory());
    }

    @Test
    public void checkisfile(){
        filestm = Test_Fixtures.nfs();
        assertFalse(filestm.getRootDirs().getFirst().getSubDirectories().get(2).getChildren().get(0).isFile());
    }
}

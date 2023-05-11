package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.FileSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CountingVisitorTest {

    public static FileSystem flstem;

    static Test_Fixtures tt= new Test_Fixtures();
    @BeforeAll
    public static void setFlstem() {
       flstem = tt.nfs();
    }

    @Test
    public void getlnkcnt() {

        flstem = Test_Fixtures.nfs();
        CountingVisitor vtr = new CountingVisitor();
        flstem.getRootDirs().getFirst().accept(vtr);
        assertEquals(1, vtr.getLinkNumber());
    }

    @Test
    void getdircnt() {
        CountingVisitor vtr = new CountingVisitor();
        flstem.getRootDirs().getFirst().accept(vtr);
        System.out.println(flstem.getRootDirs().getFirst().countChildren());
        assertEquals(5, vtr.getDirNumber());
    }

    @Test
    void getflcnt() {
        CountingVisitor vtr = new CountingVisitor();
        flstem.getRootDirs().getFirst().accept(vtr);
        assertEquals(5, vtr.getflNumber());
    }
}
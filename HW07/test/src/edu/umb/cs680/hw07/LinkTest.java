package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    private static FileSystem filestm;

    @Test
    public void checkislink() {
        filestm = Test_Fixtures.nfs();
        assertTrue(filestm.getRootDirs().getFirst().getChildren().get(4).isLink());
    }


}
package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.FileSystem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileCrawlingVisitorTest {
    public static FileSystem flstem;

    @Test
    void getFileCountInFileSystem() {
        flstem = Test_Fixtures.nfs();
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        flstem.getRootDirs().getFirst().accept(visitor);
        assertEquals(5,visitor.getFiles().size());
    }

}
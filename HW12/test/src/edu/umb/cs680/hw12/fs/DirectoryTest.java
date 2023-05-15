package edu.umb.cs680.hw12.fs;


import edu.umb.cs680.hw12.comparator.AlphabeticalComparator;
import edu.umb.cs680.hw12.comparator.ReverseAlphabeticalComparator;
import edu.umb.cs680.hw12.comparator.SizeComparator;
import edu.umb.cs680.hw12.comparator.TimeStampComparator;
import edu.umb.cs680.hw12.fs.util.Test_Fixtures;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    public static FileSystem fileSystem;

    @BeforeAll
    static void provisionFileSystem() {
        fileSystem = Test_Fixtures.nfs();
    }

    @Test
    void getAlphabeticalComparator() {
        LinkedList<FSElement> toBeSortedList;
        toBeSortedList = fileSystem.getRootDirs().getFirst().getChildren(new AlphabeticalComparator());
        assertEquals("lib", toBeSortedList.get(0).getName());
        assertEquals("src", toBeSortedList.get(1).getName());
        assertEquals("test", toBeSortedList.get(2).getName());
        assertEquals("x", toBeSortedList.get(3).getName());
    }

    @Test
    void getReverseAlphabeticalComparator() {
        LinkedList<FSElement> toBeSortedList;
        toBeSortedList = fileSystem.getRootDirs().getFirst().getChildren(new ReverseAlphabeticalComparator());
        assertEquals("x", toBeSortedList.get(1).getName());
        assertEquals("test", toBeSortedList.get(2).getName());
        assertEquals("src", toBeSortedList.get(3).getName());
        assertEquals("lib", toBeSortedList.get(4).getName());
    }

    @Test
    void getSizeComparator() {
        LinkedList<FSElement> toBeSortedList;
        toBeSortedList = fileSystem.getRootDirs().getFirst().getChildren(new SizeComparator());
        assertEquals("test", toBeSortedList.get(3).getName());
        assertEquals("src", toBeSortedList.get(2).getName());
        assertEquals("lib", toBeSortedList.get(1).getName());
        assertEquals("x", toBeSortedList.get(0).getName());
    }

    @Test
    void getTimeStampComparator() {
        LinkedList<FSElement> toBeSortedList;
        toBeSortedList = fileSystem.getRootDirs().getFirst().getChildren(new TimeStampComparator());
        assertEquals("y", toBeSortedList.get(0).getName());
        assertEquals("test", toBeSortedList.get(1).getName());
        assertEquals("lib", toBeSortedList.get(2).getName());
        assertEquals("x", toBeSortedList.get(3).getName());
    }

}

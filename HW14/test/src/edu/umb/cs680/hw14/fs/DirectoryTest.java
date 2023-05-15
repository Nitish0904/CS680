package edu.umb.cs680.hw14.fs;


import edu.umb.cs680.hw14.comparator.AlphabeticalComparator;
import edu.umb.cs680.hw14.comparator.ReverseAlphabeticalComparator;
import edu.umb.cs680.hw14.comparator.SizeComparator;
import edu.umb.cs680.hw14.comparator.TimeStampComparator;
import edu.umb.cs680.hw14.fs.util.Test_Fixtures;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        toBeSortedList = fileSystem.getRootDirs().getFirst().getChildren((o1, o2)->o1.getName().compareTo(o2.getName()));
        assertEquals("lib", toBeSortedList.get(0).getName());
        assertEquals("src", toBeSortedList.get(1).getName());
        assertEquals("test", toBeSortedList.get(2).getName());
        assertEquals("x", toBeSortedList.get(3).getName());
    }

    @Test
    void getReverseAlphabeticalComparator() {
        LinkedList<FSElement> toBeSortedList;
        toBeSortedList = fileSystem.getRootDirs().getFirst().getChildren((o1, o2)->o2.getName().compareTo(o1.getName()));
        assertEquals("x", toBeSortedList.get(1).getName());
        assertEquals("test", toBeSortedList.get(2).getName());
        assertEquals("src", toBeSortedList.get(3).getName());
        assertEquals("lib", toBeSortedList.get(4).getName());
    }

    @Test
    void getSizeComparator() {
        LinkedList<FSElement> toBeSortedList;
        toBeSortedList = fileSystem.getRootDirs().getFirst().getChildren((o1, o2)->o2.getSize() - (o1.getSize()));
        assertEquals("test", toBeSortedList.get(3).getName());
        assertEquals("src", toBeSortedList.get(2).getName());
        assertEquals("lib", toBeSortedList.get(1).getName());
        assertEquals("x", toBeSortedList.get(0).getName());
    }

    @Test
    void getTimeStampComparator() {
        LinkedList<FSElement> toBeSortedList;
        toBeSortedList = fileSystem.getRootDirs().getFirst().getChildren((o1, o2)-> o2.getCreationTime().compareTo(o1.getCreationTime()));
        assertEquals("y", toBeSortedList.get(0).getName());
        assertEquals("test", toBeSortedList.get(1).getName());
        assertEquals("lib", toBeSortedList.get(2).getName());
        assertEquals("x", toBeSortedList.get(3).getName());
    }

}

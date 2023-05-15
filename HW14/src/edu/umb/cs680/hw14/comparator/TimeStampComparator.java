package edu.umb.cs680.hw14.comparator;

import edu.umb.cs680.hw14.fs.FSElement;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement o1, FSElement o2) {
        return o2.getCreationTime().compareTo(o1.getCreationTime());
    }
}

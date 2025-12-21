package behavioral.Iterator.iterators;

import behavioral.Iterator.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
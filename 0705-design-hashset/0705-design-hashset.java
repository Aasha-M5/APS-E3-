import java.util.BitSet;

class MyHashSet {
    BitSet set;

    public MyHashSet() {
        set = new BitSet(1000001);
    }

    public void add(int key) {
        set.set(key);
    }

    public void remove(int key) {
        set.clear(key);
    }

    public boolean contains(int key) {
        return set.get(key);
    }
}
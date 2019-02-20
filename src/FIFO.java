import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO implements Queue {

    private ArrayList<Object> arrayList = new ArrayList<>();
    private int maxSize = 0;

    @Override
    public void add(Object item) {
        arrayList.add(item);
        if (arrayList.size() > maxSize) {
            maxSize = arrayList.size();
        }
    }

    @Override
    public void removeFirst() throws NoSuchElementException {
        if (arrayList.size() == 0) {
            throw new NoSuchElementException("List empty!");
        }
        arrayList.remove(0); // Consider using LinkedList?
    }

    @Override
    public Object first() throws NoSuchElementException {
        if (arrayList.size() == 0) {
            throw new NoSuchElementException("List empty!");
        }
        return arrayList.get(0);
    }

    @Override
    public int maxSize() {
        return maxSize;
    }

    @Override
    public boolean isEmpty() {
        return arrayList.size() == 0;
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Queue: ");

        for (Object o : arrayList) {
            sb.append("(" + o + ") "); // o.toString() is redundant.
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object f) {
        if (!(f instanceof FIFO)) {
            throw new ClassCastException("That is not a FIFO object!");
        }

        final int SIZE = this.size();
        if (SIZE != ((FIFO) f).size()) {
            return false;
        }

        for (int i = 0; i < SIZE; i++) {
            if (arrayList.get(i) == null) {
                if (((FIFO) f).arrayList.get(i) != null) {
                    return false;
                }
            } else if (!arrayList.get(i).equals(((FIFO) f).arrayList.get(i))) {
                return false;
            }
        }

        return true;
    }
}

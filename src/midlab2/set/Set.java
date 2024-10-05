package midlab2.set;

import java.util.NoSuchElementException;

public interface Set<E> {
    public int getSize();
    public void insert(E data);
    public E getElement(E data) throws NoSuchElementException;
}

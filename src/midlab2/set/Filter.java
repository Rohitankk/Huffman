package midlab2.set;

public interface Filter<T> {
    void whenFiltered(T data);

    boolean whatToFilter(T data1, T data2);
}

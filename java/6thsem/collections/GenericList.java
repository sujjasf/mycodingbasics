package collections;

public class GenericList<T> {
    public T[] items = (T[]) new Object[10];
    private int count;

    public void add(T item) { items[count++] = item; }
    public T get(int index) { return items[index]; }
}
package lists;

public interface List<T> {
  public T get(int index);
  public void add(T obj);
  public void set(int index, T obj);
  public int indexOf(T obj);
  public T remove(int index);
  public boolean remove(T obj);
}

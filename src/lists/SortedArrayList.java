package lists;


public class SortedArrayList<T extends Comparable<? super T>> {
  
  private T[] list;
  private int size;
  private final int DEFAULT_CAPACITY = 2;
  private boolean ascending;
  
  public SortedArrayList() {
    clear();
  }
  
  @SuppressWarnings("unchecked")
  public void clear() {
    list = (T[])new Comparable[DEFAULT_CAPACITY];
    size = 0;
    ascending = true;
  }
  
  public int getSize() {
    return size;
  }
  
  public String toString() {
    StringBuffer sb = new StringBuffer("(");
    if (size > 0) {
      for (int i = 0; i < size - 1; i++) {
        sb.append(list[i]);
        sb.append(", ");
      }
      sb.append(list[size - 1]);
    }
    sb.append(")");
    return sb.toString();
  }

  public T get(int index) {
    validateIndex(index, 0, size - 1);
    return list[index];
  }

  private void validateIndex(int index, int lowerBound, int upperBound) {
    if (index < lowerBound || index > upperBound)
      throw new IndexOutOfBoundsException(String.format("Index must be between %d and %d", lowerBound, upperBound));    
  }

  public void add(T obj) {
    ensureCapacity();
    int addIndex = getAddIndex(obj);
    add(addIndex, obj);
  }
  
  private int getAddIndex(T obj) {
    if (isEmpty())
      return 0;
    int index = 0;
    if (ascending)
      while (list[index] != null && list[index].compareTo(obj) < 0)
        index++;
    else
      while (list[index] != null && list[index].compareTo(obj) > 0)
        index++;
    return index;
  }

  private boolean isEmpty() {
    return size == 0;
  }

  private void add(int addIndex, T obj) {
    ensureCapacity();
    if (addIndex == 0)
      prepend(obj);
    else if (addIndex == size)
      append(obj);
    else
      insert(addIndex, obj);
    size++;
  }

  private void insert(int addIndex, T obj) {
    shiftRight(addIndex);
    list[addIndex] = obj;
  }

  private void append(T obj) {
    list[size] = obj;
  }

  private void prepend(T obj) {
    shiftRight(0);
    list[0] = obj;    
  }

  private void shiftRight(int index) {
    for (int i = size; i > index; i--) {
      list[i] = list[i - 1];
    }
  }

  @SuppressWarnings("unchecked")
  private void ensureCapacity() {
    if (size == list.length) {
      T[] temp = (T[]) new Comparable[list.length * 2 + 1];
      for (int i = 0; i < size; i++)
        temp[i] = list[i];
      list = temp;
    }
  }

  public T remove(int index) {
    if (isEmpty())
      throw new EmptyCollectionException("Cannot remove from an empty list");
    validateIndex(index, 0, size - 1);
    T obj = list[index];
    shiftLeft(index);
    size--;
    return obj;
  }

  private void shiftLeft(int index) {
    for (int i = index; i < size - 1; i++) {
      list[i] = list[i + 1];
    }
  }

  @SuppressWarnings("unchecked")
  public void reverse() {
    ascending = !ascending;
    if (size > 1) {
      T[] temp = (T[]) new Comparable[size];
      for (int i = 0, j = size - 1; i < size; i++, j--) {
        temp[i] = list[j];
      }
      list = temp;
    }
  }
  
  public boolean contains(T obj) {
    if (isEmpty())
      return false;
    for (int i = 0; i < size; i++) {
      if (list[i].equals(obj))
        return true;
    }
    return false;
  }

}

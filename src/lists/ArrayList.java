package lists;

public class ArrayList<T> implements List<T> {
  
  private final int DEFAULT_CAPACITY = 25;
  private int size;
  private T[] arr;
  
  public ArrayList() {
    clear();
  }
  
  @SuppressWarnings("unchecked")
  public void clear() {
    arr = (T[])(new Object[DEFAULT_CAPACITY]);
    size = 0;
  }
  
  public int getSize() {
    return size;
  }

  @Override
  public T get(int index) {
    validateIndex(index, 0, size);
    return arr[index];
  }

  @Override
  public void add(T obj) {
    add(size, obj);
  }
  
  public void add(int index, T obj) {
    validateIndex(index, 0, size);
    ensureCapacity();
    if (index == size) {
      append(obj);
    } else {
      shiftRight(index);
      arr[index] = obj;
      size++;
    }
  }
  
  public void append(T obj) {
    if (size == arr.length) {
      resizeArray();
    }
    arr[size] = obj;
    size++;
  }
  
  public String toString() {
    StringBuffer s = new StringBuffer();
    s.append("[");
    for (int i = 0; i < size - 1; i++) {
      s.append(arr[i].toString());
      s.append(", ");
    }
    s.append(arr[size - 1]);
    s.append("]");    
    return s.toString();
  }

  @Override
  public void set(int index, T obj) {
    validateIndex(index, 0, size);
    arr[index] = obj;
  }

  @Override
  public int indexOf(T obj) {
    for (int i = 0; i < size; i++) {
      if (arr[i].equals(obj)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public T remove(int index) {
    validateIndex(index, 0, size);
    T obj = arr[index];
    shiftLeft(index);
    size--;
    return obj;
  }

  @Override
  public boolean remove(T obj) {
    if (indexOf(obj) == -1) {
      return false;
    } else {
      shiftLeft(indexOf(obj));
      size--;
      return true;
    }
  }
  
  private void ensureCapacity() {
    if (size == arr.length)
      resizeArray();
  }
  
  @SuppressWarnings("unchecked")
  private void resizeArray() {
    T[] temp = (T[])(new Object[arr.length * 2 + 1]);
    for (int i = 0; i < arr.length; i++) {
      temp[i] = arr[i];
    }
    arr = temp;
  }
  
  private void validateIndex(int index, int lowerBound, int upperBound) {
    if (!(index >= 0 && index <= size)) {
      throw new IndexOutOfBoundsException(String.format("Index must be between %d and %d", lowerBound, upperBound));
    }
  }
  
  private void shiftRight(int index) {
    for (int i = size; i > index; i--) {
      arr[i] = arr[i - 1];
    }
  }
  
  private void shiftLeft(int index) {
    for (int i = index; i < size - 1; i++) {
      arr[i] = arr[i + 1];
    }
    arr[size] = null;
  }

}

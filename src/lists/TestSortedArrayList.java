package lists;

public class TestSortedArrayList {

  public static void main(String[] args) {

    SortedArrayList<Character> list = new SortedArrayList<>();

    list.add('m');
    list.add('a');
    System.out.println(list);
    list.reverse();
    list.add('z');
    list.add('p');
    System.out.println("contains('z'): " + list.contains('z'));
    System.out.println("contains('r'): " + list.contains('r'));
    
    System.out.println(list);
    list.reverse();
    System.out.println(list);
    
    list.remove(0);
    list.remove(list.getSize() - 1);
    System.out.println(list);
    list.remove(1);
    list.remove(0);
    
    System.out.println(list);
    try {
      list.remove(0);
      System.out.println("Exception not caught: Fail");
    } catch (EmptyCollectionException e) {
      System.out.println("Exception caught: " + e.toString());
    }

  }

}

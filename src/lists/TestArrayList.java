package lists;

public class TestArrayList {

  public static void main(String[] args) {

    ArrayList<Integer> list = new ArrayList<>();
    list.add(0, 1);
    list.add(1, 5);
    System.out.println(list);
    list.add(2, 3);
    list.add(3, 7);
    System.out.println(list);
    list.add(4, 9);
    System.out.println(list);
    list.add(2, 13);
    System.out.println(list);
    System.out.println(list.getSize());
    for (int i = 0; i < 50; i++)
      list.append(2 * i + 1);
    System.out.println(list);
    
    list.remove((Integer)13);
    System.out.println(list);
    Integer num = list.remove(20);
    System.out.println(num);
    System.out.println(list);
    System.out.println(list.indexOf(21));

  }

}

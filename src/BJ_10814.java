import java.util.*;

class Person implements Comparable{
  int age;
  String name;
  int join_order;

  public Person(int age, String name, int join_order) {
    this.age = age;
    this.name = name;
    this.join_order = join_order;
  }

  @Override
  public String toString() {
    return "Person{" +
            "age=" + age +
            ", name='" + name + '\'' +
            ", join_order=" + join_order +
            '}';
  }

  @Override
  public int compareTo(Object o2) {
    Person p2 = (Person) o2;
    if(this.age == p2.age){
      return this.join_order - p2.join_order;
    }else{
      return this.age - p2.age;
    }
  }
}

public class BJ_10814 {
  public static void main() {
    Scanner sc = new Scanner(System.in);
    ArrayList<Person> myList = new ArrayList<>();
    int numPpl = sc.nextInt();
    int joinNum = 0;
    while (numPpl-- > 0) {
      myList.add(new Person(sc.nextInt(), sc.next(), joinNum++));
    }

    Collections.sort(myList);
/*    myList.sort( (p1, p2) -> {
      if (p1.age == p2.age) {
        return p1.join_order - p2.join_order;
      } else {
        return p1.age - p2.age;
      }
    });*/
/*    Collections.sort(myList, new Comparator<Person>() {
      @Override
      public int compare(Person p1, Person p2) {
        if (p1.age == p2.age) {
          return p1.join_order - p2.join_order;
        } else {
          return p1.age - p2.age;
        }
      }

      @Override
      public boolean equals(Object obj) {
        return false;
      }
    });*/

    for(Person p : myList){
      System.out.println(p.age + " " + p.name);
    }
  }
}

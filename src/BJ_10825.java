import java.util.Scanner;
import java.util.ArrayList;

class Human {
  String name;
  int mathScore;
  int korScore;
  int engScore;

  public Human(String name, int korScore, int engScore, int mathScore) {
    this.name = name;
    this.korScore = korScore;
    this.engScore = engScore;
    this.mathScore = mathScore;
  }

  @Override
  public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            ", korScore=" + korScore +
            ", engScore=" + engScore +
            ", mathScore=" + mathScore +
            '}';
  }
}

public class BJ_10825 {
  public static void main() {
    Scanner sc = new Scanner(System.in);
    ArrayList<Human> myList = new ArrayList<>();

    int numPpl = sc.nextInt();
    while (numPpl-- > 0) {
      myList.add(new Human(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
    }

    myList.sort((h1, h2) -> {
      if (h1.korScore == h2.korScore) {
        if (h1.engScore == h2.engScore) {
          if (h1.mathScore == h2.mathScore) {
            //lexigraphical
            return h1.name.compareTo(h2.name);
          }
          return h2.mathScore - h1.mathScore;
        }
        return h1.engScore - h2.engScore;
      }
      return h2.korScore - h1.korScore;
    });

    for(Human p: myList){
      System.out.println(p.name);
    }
  }
}



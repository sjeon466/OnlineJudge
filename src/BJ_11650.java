
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

class Point{
  int x;
  int y;
  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }
}

public class BJ_11650 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numPoints = sc.nextInt();
    ArrayList<Point> points = new ArrayList<>();

    for(int i=0; i<numPoints; i++){
      points.add(new Point(sc.nextInt(), sc.nextInt()));
    }

    points.sort( (Point p1, Point p2) ->  {
      if(p1.y == p2.y){
        return p1.x - p2.x;
      } else{
        return p1.y - p2.y;
      }
    });

/*    points.sort(new Comparator<Point>() {
      @Override
      public int compare(Point p1, Point p2) {
        if(p1.c == p2.c){
          return p1.r - p2.r;
        } else{
          return p1.c - p2.c;
        }
      }
    });*/

    for(Point p : points){
      System.out.println(p.x + " " + p.y);
    }
  }
}




import java.sql.SQLOutput;
import java.util.*;

class Ppoint {
  private int x;
  private int y;

  public Ppoint(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public String toString() {
    return "{r=" + this.getX() + ", c=" + this.getY() + "}";
  }
}
  public class BJ_2261_2 {
    private int calcDist(Ppoint p1, Ppoint p2) {
      return (p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) +
              (p1.getY() - p2.getY()) * (p1.getY() - p2.getY());
    }


    public static void main() {
      Scanner sc = new Scanner(System.in);
      int numPoints = sc.nextInt();
      Ppoint[] points = new Ppoint[numPoints];

      for (int i = 0; i < numPoints; i++) {
        points[i] = new Ppoint(sc.nextInt(), sc.nextInt());
      }

/*
      System.out.println("before Sort");
      System.out.println(Arrays.toString(points));
*/

      Arrays.sort(points, new Comparator() {
        public int compare(Object o1, Object o2) {
          Ppoint p1 = (Ppoint) o1;
          Ppoint p2 = (Ppoint) o2;

          if (p1.getX() == (p2.getX())) {
            return p1.getY() - p2.getY();
          } else {
            return p1.getX() - p2.getX();
          }
        }
      });

/*
      System.out.println("after Sort");
      System.out.println(Arrays.toString(points));

      System.out.println("after c sort");
      Arrays.sort(points,new YComparator());
      System.out.println(Arrays.toString(points));
*/


    }


    private int closest(Ppoint[] points, int start, int end) {
      int numPoints = end - start - 1;

      if (numPoints <= 3) {
        return brute_force(points, start, end);
      }

      int midPoint = (start + end) / 2;
      int leftMinDistance = closest(points, start, midPoint);
      int rightMinDistance = closest(points, midPoint+ 1, end);
      int ans = Math.min(leftMinDistance, rightMinDistance);

      List<Ppoint> list = new ArrayList<Ppoint>();
      for(int i = start; i <= end; i++){
        int d = points[i].getX() - points[midPoint].getX();
        if(d * d < ans){
          list.add(points[i]);
        }
      }

      list.sort(new YComparator());
      int newListSize=  list.size();

      for(int i = 0; i < newListSize - 1; i++){
        for(int j = i + 1; j < newListSize; j++){
          int yDiff = list.get(i).getY() - list.get(j).getY();
          if(yDiff * yDiff < ans){
            int dist = calcDist(list.get(i), list.get(j));
            if(dist < ans){
              ans = dist;
            }else{
              break;
            }
          }
        }
      }
      return ans;
    }

    private int brute_force(Ppoint[] points, int start, int finish) {
      int ans = -1;

      for(int i = start; i <= finish-1; i++){
        for(int j = start + 1; j <=finish; j++){
          int d = calcDist(points[i], points[j]);
          if(ans == -1 || ans > d){
            ans = d;
          }
        }
      }
      return ans;
    }
  }

class YComparator implements Comparator<Ppoint> {
  public int compare(Ppoint p1, Ppoint p2) {
    return p1.getY() - p2.getY();
  }
}

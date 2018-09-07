import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class LC_51 {
  static class Point{
    int r;
    int c;
    public Point(int r, int c){
      this.r = r;
      this.c = c;
    }
    @Override
    public String toString(){
      return "{" + r + "," + c + "}";
    }
  }

  public static void main(){
    LC_51 l = new LC_51();

    /*  List<String> list = l.convertToList(new Point[]{
             new Point(0,1), new Point(1,3), new Point(2,0), new Point(3,2)});
    */

    /*     for(String curLine : list){
     System.out.println(curLine);
    }*/

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    List<List<String>> result = l.solveNQueens(n);
    System.out.println(Arrays.toString(result.toArray()));
  }

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> results  = new ArrayList<>();

    List<String> result1 = new ArrayList<>();
    Point[] points = new Point[n];

    for(int i = 0; i < points.length; i++){
      if(canSolve(n,new Point(0,i), points)){
        results.add(convertToList(points));
      }else{
        continue;
      }
    }

 /*   for(int r = 0 ; r < n; r++){
      for(int c = 0; c < n; c++){
        Point[] points = new Point[n];
        if(canSolve(n, new Point(r, c), points)){
          result.add(convertToList(points));
        }
      }
    }*/
    return results;
  }

  private List<String> convertToList(Point[] points) {
    List<String> grid =  new ArrayList<>(); //new ArrayList<String>(points.length);
      for(int i = 0; i < points.length; i++){
      //System.out.println(points[i]);
      StringBuilder sb = new StringBuilder();
      sb.append("\"");
      for(int k = 0; k < points.length; k++){
        sb.append(".");
      }
      sb.append("\"");
      //System.out.println("points[" + i + "].c =" + points[i].c);
      sb.replace(points[i].c + 1,points[i].c + 2,"Q");
      //System.out.println(sb.toString());
      //grid.add(sb.toString());
      grid.add(i, sb.toString());
    }
    return grid;
  }

  private boolean canSolve(int n, Point p, Point[] points ){
    // reached the end safe combination is complete.

    if(p.r == n) return true;

    //int curRow = p.r;
    //iterate the path so far to see if cur Queen position violates
    // existing queens
    for(int i = 0; i < p.r; i++){
     //System.out.println(  "cur P = " + p +  ", checking prevQueen at index= "+ i);
      Point prevQueen = points[i];
      if(p.r == prevQueen.r || p.c == prevQueen.c ||
              (p.r + p.c) == (prevQueen.r + prevQueen.c) ||
              (p.r - p.c) == (prevQueen.r - prevQueen.c) ){
        return false;
      }
    }

    //passes all existing queens condition
    //put the curSpot into points combination
    points[p.r] = p;

    //try next row's everything possible position
    for(int c = 0; c < points.length; c++){
      if(canSolve(n, new Point(p.r + 1, c), points)){
        return true;
      }else{
        continue;
      }
    }
    return false;
  }
}

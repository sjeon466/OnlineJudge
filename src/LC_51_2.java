import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LC_51_2 {

  public static void main(){
    LC_51_2 l = new LC_51_2();

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    List<List<String>> result = l.solveNQueens(n);
    System.out.println(Arrays.toString(result.toArray()));
  }


  class Position {
    int r, c;

    public Position(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  public List<List<String>> solveNQueens(int n){
    List<List<String>> results = new ArrayList<>();
    for(int i = 0; i < n; i++){
      Position[] positions = new Position[n];
      boolean hasSolution = solveNQueenOneSolutionUtil(n, 0, positions);
      if(hasSolution){
        results.add(convertToList(positions));
      }
    }
    return results;
  }

  private boolean solveNQueenOneSolutionUtil(int n, int row, Position[] positions){
    if(row == n){
      return true;
    }
    int col;
    for(col = 0; col < n; col++){
      boolean foundSafe = true;
      // check if row and col is not under attack from any previous queen.
      for(int i = 0; i < row; i++){
        Position prevQueen = positions[i];
        if(row == prevQueen.r || col == prevQueen.c ||
                (row + col) == (prevQueen.r + prevQueen.c) || (row - col) == (prevQueen.r - prevQueen.c)){
            foundSafe = false;
          break;
        }
      }
      if(foundSafe){
        positions[row] = new Position(row, col);
        if(solveNQueenOneSolutionUtil(n, row + 1, positions)){
          return true;
        }
      }
    }
    return false;
  }


  private List<String> convertToList(Position [] positions) {
    List<String> grid =  new ArrayList<>(); //new ArrayList<String>(points.length);
    for(int i = 0; i < positions.length; i++){
      //System.out.println(points[i]);
      StringBuilder sb = new StringBuilder();
      //sb.append("\"");
      for(int k = 0; k < positions.length; k++){
        sb.append(".");
      }
      //sb.append("\"");
      //System.out.println("points[" + i + "].c =" + points[i].c);
      sb.replace(positions[i].c,positions[i].c + 1,"Q");
      //System.out.println(sb.toString());
      //grid.add(sb.toString());
      grid.add(i, sb.toString());
    }
    return grid;
  }
}
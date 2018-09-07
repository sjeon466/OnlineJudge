import java.util.*;

public class LC_675 {
  static int[] dR = new int[]{-1,1, 0,0};
  static int[] dC = new int[]{ 0,0,-1,1};


  public static void main(){

  /*[
   [2,3,4],
   [0,0,5],
   [8,7,6]
  ]*/

    List<Integer> row1 = new ArrayList<>();
    row1.add(2);
    row1.add(3);
    row1.add(4);
    List<Integer> row2 = new ArrayList<>();
    row2.add(0);
    row2.add(0);
    row2.add(5);
    List<Integer> row3 = new ArrayList<>();
    row3.add(8);
    row3.add(7);
    row3.add(6);

    List<List<Integer>> grid = new ArrayList<>();
    grid.add(row1);
    grid.add(row2);
    grid.add(row3);
    LC_675 l = new LC_675();
    System.out.println(l.cutOffTree(grid));

  }

  public int cutOffTree(List<List<Integer>> forest) {

    if(forest == null || forest.size() == 0) return -1;

    int[][] grid = generateGrid(forest);
    boolean[][] visited = new boolean[grid.length][grid[0].length];

    List<Integer> nums = new ArrayList<>();
    for(List<Integer> curRow : forest){
      for(int curNum : curRow){
        if(curNum != 0) nums.add(curNum);
      }
    }
    Collections.sort(nums);
    System.out.println(Arrays.toString(nums.toArray()));


    // bfs to try to reach the next lowest tree.


    // curRow , curCol, numStepTaken
    return go(0,0,0, 0, nums, grid, visited);
  }

  private int go(int curRow, int curCol, int numStepTaken, int nextNumIndexToVisit, List<Integer> numsToVisit, int[][] grid, boolean[][] visited) {
    // if destination
    if(grid[curRow][curCol] == numsToVisit.get(numsToVisit.size() - 1)){
      return ++numStepTaken;
    }

    // process current val
    int curTreeVal = grid[curRow][curCol];
    nextNumIndexToVisit++;
    visited[curRow][curCol] = true;
    grid[curRow][curCol] = 1;
    if(!(curRow == 0 && curCol == 0)){
      numStepTaken++;
    }

    // process for the next tree
    for(int i = 0; i < 4; i++){
      int nR = curRow + dR[i];
      int nC = curCol + dC[i];

      // do range check before visiting
      if( (0 <= nR && nR < grid.length) && (0 <= nC && nC < grid[0].length)){
        if(grid[nR][nC] != 0 && visited[nR][nC] == false &&

          // you can go to places where there is grass or the next destination tree
                ( grid[nR][nC] == 1 || grid[nR][nC] ==  numsToVisit.get(nextNumIndexToVisit))  ) {
          go(nR, nC, numStepTaken, nextNumIndexToVisit, numsToVisit, grid, visited);
        }
      }
      // check if the next tree is valid tree.



    }


    return -1;
  }

  private int[][] generateGrid(List<List<Integer>> forest) {
    int[][] grid = new int[forest.size()][forest.get(0).size()];

    for(int r = 0; r < forest.size(); r++){
      List<Integer> curRow = forest.get(r);
      for(int c = 0; c < curRow.size(); c++){
        int curVal = curRow.get(c);
        grid[r][c] = curVal;
      }
    }
    return grid;
  }
}

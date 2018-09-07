import java.util.*;



public class LC_826 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    LC_826 l = new LC_826();
    System.out.println(l.maxProfitAssignment(
   /*    new int[]{2 ,4 ,6 ,8 ,10},
       new int[]{10,20,30,40,50},
       new int[]{4,5,6,7}*/
            new int[]{68,35,52,47,86},
            new int[]{67,17,1,81,3},
            new int[]{92,10,85,84,82}
    ));

  }


  class Work implements Comparable{
    int difficulty;
    int profit;
    public Work(int difficulty, int profit){
      this.difficulty = difficulty;
      this.profit = profit;
    }

    @Override
    public int compareTo(Object o) {
      return this.profit - ((Work)o).profit;
    }

    @Override
    public int hashCode() {
      return Objects.hash(difficulty, profit);
    }

    @Override
    public String toString(){
      return ("diff=" + this.difficulty + " , profit=" + this.profit);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Work)) return false;
      Work work = (Work) o;
      return difficulty == work.difficulty &&
              profit == work.profit;
    }
  }


  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
/*    Arrays.sort(difficulty);
    Arrays.sort(profit);
    Arrays.sort(worker);*/
    List<Work> works = new ArrayList<Work>();
    for(int i = 0; i < difficulty.length; i++){
      works.add(new Work(difficulty[i], profit[i]));
    }
    Collections.sort(works);
    Arrays.sort(worker);

    int totalProfit = 0;
    int workerIndex = worker.length - 1;
    int ithWork = difficulty.length - 1;

    while(ithWork >=0 && workerIndex >= 0){
      Work curWork = works.get(ithWork);
      if(curWork.difficulty <= worker[workerIndex]){
        totalProfit += curWork.profit;
        workerIndex--;
      }else{
        ithWork--;
      }
    }
    return totalProfit;
    /*for(int workerIndex = worker.length - 1, ithWorkPointer = difficulty.length - 1;
    ithWorkPointer >= 0 && workerIndex >= 0; ithWorkPointer--){
    }*/
  }
}

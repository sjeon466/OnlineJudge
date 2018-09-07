import java.util.*;
public class HR_Algo_Sort_FraudActivity {
  private static Map<Integer, Integer> prioMap = new HashMap(201, 1.0f);

  // Queue to remove old values while moving forward during median calculation
  private static Queue<Integer> oldValues = new LinkedList();
  private static int medIdx;
  private static boolean isEven = false;

  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numDays = sc.nextInt();
    int numTrailingDays = sc.nextInt();

    if(numTrailingDays > numDays){
      System.out.println(0);
      return;
    }

    // Calculating median index
    // and putting even flag that will be used to calculate the median

    if(numTrailingDays % 2 == 0){
      isEven = true;
      medIdx = numTrailingDays/ 2 - 1;
    }else{
      medIdx = numTrailingDays / 2;
    }

    // Generating initial Map
    for(int i=0; i < numTrailingDays; i++){
      int value = sc.nextInt();
      oldValues.add(value);
      addToMap(value);
    }

    int notiCount = 0;
    
    for(int i = numTrailingDays; i < numDays; i++){
      int curExpendVal = sc.nextInt();
      oldValues.add(curExpendVal);
      double median = findMedian();

      if(curExpendVal >= 2 * median){
        notiCount++;
      }

      // Removing old values from Queue
      int oldVal = oldValues.poll();
      if(prioMap.containsKey(oldVal)){
        int oldCount = prioMap.get(oldVal);
        if(oldCount > 1){
          prioMap.put(oldVal, --oldCount);
        }else{
          prioMap.remove(oldVal);
        }
      }

      // Add the new value
      addToMap(curExpendVal);
    }
    System.out.println(notiCount);
  }

  private static double findMedian() {
    int medianCount = 0;
    // Case if even we need 2 values to calculate median
    if(isEven){
      Iterator<Integer> iter = prioMap.keySet().iterator();
      while(iter.hasNext()){
        int curKey = iter.next();
        medianCount += prioMap.get(curKey);
        if( medianCount - 1 > medIdx){
          return 1.0 * curKey;
        } else if(medianCount - 1 == medIdx){
          return (1.0 * (curKey + iter.next())) / 2;
        }
      }
    }else{
      for(Integer curKey : prioMap.keySet()){
        medianCount += prioMap.get(curKey);
        if(medianCount - 1 > medIdx){
          return 1.0 * curKey;
        }
      }
    }
    return -1.0;
  }

  private static void addToMap(int value) {
    if(prioMap.containsKey(value)){
      prioMap.put(value, prioMap.get(value) + 1);
    }else{
      prioMap.put(value, 1);
    }
  }







/*
  // Complete the activityNotifications function below.
  static int activityNotifications(int[] expenditure, int numTrailingDays) {
    int[] counterExpenditure = new int[201];
    int i = 0, trailDays = numTrailingDays;

    for (; i < expenditure.length; i++) {
      counterExpenditure[expenditure[i]]++;
    }

    i = 0;
    long numNoti = 0;
    int medianPosition = (trailDays % 2 != 0) ?
            (numTrailingDays / 2) + 1 : numTrailingDays / 2;

    while (trailDays < expenditure.length) {
      double median = getMedian(counterExpenditure, numTrailingDays, medianPosition);


    }

    return -1;
  }

  private static double getMedian(int[] counterExpenditure, int numTrailingDays, int medianPosition) {
    int count = 0, i = 0, j = 0;
      for(; count < medianPosition; i++){
        count += counterExpenditure[i];
      }

      j = i;
      i -= 1;

      if(count > medianPosition || numTrailingDays % 2 != 0){
        return i;
      }
      for(; counterExpenditure[j] == 0; j++){
        return (i + j) / 2;
      }
    return 0;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main() throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nd = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nd[0]);

    int d = Integer.parseInt(nd[1]);

    int[] expenditure = new int[n];

    String[] expenditureItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int expenditureItem = Integer.parseInt(expenditureItems[i]);
      expenditure[i] = expenditureItem;
    }

    int result = activityNotifications(expenditure, d);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }*/
}

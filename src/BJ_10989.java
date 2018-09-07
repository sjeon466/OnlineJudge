import java.io.*;
import java.util.Scanner;

public class BJ_10989 {
  public static void main() throws IOException {
    //Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nums = Integer.parseInt(br.readLine());
    int[] arr = new int[10001];
    int idx;
    while(nums-- > 0){
      idx = Integer.parseInt(br.readLine());
      arr[idx] += 1 ;
    }

    OutputStream os = new BufferedOutputStream(System.out);
    for(int i=0; i < 10001; i++){
      while(arr[i]-- > 0){
        os.write((i + "\n").getBytes());
      }
    }
    os.flush();
  }
}

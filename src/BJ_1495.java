import java.util.Scanner;

public class BJ_1495 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numSongs = sc.nextInt();
    int startVolume = sc.nextInt();
    final int maxVolume = sc.nextInt();
    int[] volumes = new int[numSongs];
    for(int i = 0; i < volumes.length; i++){
      volumes[i] = sc.nextInt();
    }
    System.out.println(solveGuitar(numSongs, startVolume, maxVolume, volumes));
  }

  private static int solveGuitar(int numSongs, int startVolume, int maxVolume, int[] volumes) {
    int[][] memoi = new int[numSongs + 1][maxVolume + 1];

    memoi[0][startVolume] = 1;

    boolean volumeFoundforRow = false;
    for(int r = 0; r < numSongs; r++){
      volumeFoundforRow = false;
      for(int c = 0; c <= maxVolume; c++){
        if(memoi[r][c] == 1){
          volumeFoundforRow = true;
          int volumeUp = c + volumes[r];
          int volumeDown = c - volumes[r];
          if(volumeUp <= maxVolume){
            memoi[r + 1][volumeUp] = 1;
          }
          if(volumeDown >= 0){
            memoi[r + 1][volumeDown] = 1;
          }
        }
        if(c == maxVolume && volumeFoundforRow == false){
          break;
        }
      }
    }

    int result = -1;
    if(volumeFoundforRow == true){
      for(int c = 0; c <= maxVolume; c++){
        if(memoi[numSongs][c] == 1){
          result = c;
        }
      }
    }
    return result;
  }
}

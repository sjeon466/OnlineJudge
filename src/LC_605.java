public class LC_605 {
  public static void main(){
    LC_605 l = new LC_605();
    //System.out.println(l.canPlaceFlowers(new int[]{1,0,0,0,1, 0,0} , 2));
    //System.out.println(l.canPlaceFlowers(new int[]{1} , 1));
    System.out.println(l.canPlaceFlowers(new int[]{0,0,0,0,1} , 1));
  }
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    // use greedy algorithm to place flowers from index 0 to the end

    int count = 0;

    for(int i = 0; i < flowerbed.length; i++){
      if(flowerbed[i] == 0){
        int prev = (i == 0) ?  0 : flowerbed[i-1];
        int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i+1];

        if(prev == 0 && next == 0){
          flowerbed[i] = 1;
          count++;
          if(count == n) break;
        }
      }
    }
    return (count >= n);
  }
  public boolean canPlaceFlowers2(int[] flowerbed, int n) {
    int possibleFlowers = 0;
    int[] fBed = new int[flowerbed.length];
    for (int i = 0; i < fBed.length; i++) {
      fBed[i] = flowerbed[i];
    }
    if(fBed.length == 1){
      if(fBed[0] == 0){
        possibleFlowers++;
      }
    }else if(fBed.length == 2){
      if((fBed[0] == 0 && fBed[1] == 0) ){
        possibleFlowers++;
      }
    }
    // length of 3 or greater
    else {
      for (int i = 1; i < fBed.length - 1; i++) {
        if (fBed[i] == 1) continue;

        //checking for index 0
        if(fBed[0] == 0 && fBed[1] == 0){
          possibleFlowers++;
          fBed[0] = 1;
        }

        //  optimal way
        if (fBed[i - 1] == 0 && fBed[i] == 0 && fBed[i + 1] == 0) {
          possibleFlowers++;
          fBed[i] = 1;
          // at index 1
        } else if (i == 1 && fBed[i] == 0 && fBed[i - 1] == 0) {
          fBed[i - 1] = 1;
          possibleFlowers++;

          // at second to the last index
        } else if (i == fBed.length - 2 && fBed[i] == 0 && fBed[i + 1] == 0) {
          fBed[i + 1] = 1;
          possibleFlowers++;
        }
      }
    }
    return (n <= possibleFlowers) ? true : false;
  }
}

import java.util.Scanner;

public class LC_383 {
  public static void main(){
    Scanner sc = new Scanner(System.in);

    String ransomNote = sc.next();
    //System.out.println(ransomNote);
    String magazine = sc.next();
    //System.out.println("ransomNote=" + ransomNote +
    //        ", magazine=" + magazine);

    LC_383 l = new LC_383();
    System.out.println(l.canConstruct(ransomNote, magazine));
  }

  public boolean canConstruct(String ransomNote, String magazine) {
    if(ransomNote == null || magazine == null) return false;
    int[] ransomArr = new int[26];
    int[] magazineArr = new int[26];
    for(int i = 0; i < ransomNote.length(); i++){
      ransomArr[ransomNote.charAt(i) - 'a']++;
    }
    for(int i = 0; i < magazine.length(); i++){
      magazineArr[magazine.charAt(i) - 'a']++;
    }
    return canCreateRandomNote(ransomArr, magazineArr);
  }

  private boolean canCreateRandomNote(int[] ransomArr, int[] magaArr){
    for(int i = 0; i < ransomArr.length; i++){
      if(magaArr[i] - ransomArr[i] < 0) return false;
    }
    return true;
  }
}

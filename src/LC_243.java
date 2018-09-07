import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LC_243 {
  public static void main(){
    LC_243 l = new LC_243();

    String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
/*    String word1 = "coding";
    String word2 = "practice"; */
    String word1 = "makes";
    String word2 = "coding";
    System.out.println(l.shortestDistance(words, word1, word2));

  }

  public int shortestDistance(String[] words, String word1, String word2) {
    /*    List<Integer> word1Indices = new ArrayList<>();
        List<Integer> word2Indices = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
          if(words[i].equals(word1)){
            word1Indices.add(i);
          }else if(words[i].equals(word2)){
            word2Indices.add(i);
          }
        }*/
    /*
        int i = 0, j = 0;
        while(i >= word1Indices.size() || j >= word2Indices.size()){
        }*/
    int prevWord1Index = indexOf(words, word1);
    int prevWord2Index = indexOf(words, word2);
    int minDist = Math.abs(prevWord1Index - prevWord2Index);
    boolean isLasteWord1 = (prevWord1Index > prevWord2Index) ? true : false;

    for(int i = 0; i < words.length; i++){
      if(words[i].equals(word1)){
        if(!isLasteWord1){
          minDist = Math.min(minDist , Math.abs(prevWord2Index - i));
          isLasteWord1 = !isLasteWord1;
        }
        prevWord1Index = i;
      }else if (words[i].equals(word2)){
        if(isLasteWord1){
          minDist = Math.min(minDist , Math.abs(prevWord1Index - i));
          isLasteWord1 = !isLasteWord1;
        }
        prevWord2Index = i;
      }
    }
    return minDist;
  }

  private int indexOf(String[] words, String word){
    for(int i = 0; i < words.length; i++){
      if(words[i].equals(word)){
        return i;
      }
    }
    return -1;
  }
}

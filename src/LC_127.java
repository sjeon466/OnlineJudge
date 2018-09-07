import java.util.*;

public class LC_127 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    String beginWord = sc.next();
    String endWord = sc.next();
    int numWords = sc.nextInt();
    List<String> wordList = new ArrayList<String>();
    for(int i = 0; i < numWords; i++){
      wordList.add(sc.next());
    }
    LC_127 l = new LC_127();
    System.out.println(l.ladderLength(beginWord, endWord, wordList));
  }

  /*
   perform a breath first search to find the minimum transformation needed to get to the
   endWord.

   at most, the number of transformation will be N, where N is the number of words in the
   words list.

   construct graph with an arraylist of arraylists of strings to represent
   the adjacent words for a given word.

   it is unnecessary to revisit the same node because shortest transformation is needed.

   lastly, use a queue to traverse through the words list.
    */

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int numWords = wordList.size();
    Map <String, Integer> shortestDistances = new HashMap<String, Integer>();
    bfs(beginWord, endWord, wordList, shortestDistances);
    return shortestDistances.getOrDefault(endWord, 0);
  }

  private void bfs(String beginWord, String endWord, List<String> wordList, Map<String,Integer> shortestDistances){
    // iterative bfs
    Queue<String> queue = new LinkedList<String>();
    Set<String> dict = new HashSet<String>(wordList);
    Map<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();

    //initializing neighbors
    for(String word : dict){
      //neighbors.put(word, new ArrayList<String>());
    }

    shortestDistances.put(beginWord, 0);
    queue.offer(beginWord);



    while(!queue.isEmpty()){
      int count = queue.size();
      boolean foundEnd = false;
      for(int i = 0; i < count; i++){
        String curWord = queue.poll();
        int curDistance = shortestDistances.get(curWord);
        ArrayList<String> neighbors = getNeighbors(curWord, dict);

        for(String neighbor : neighbors){
          nodeNeighbors.get(curWord).add(neighbor);
          if(!shortestDistances.containsKey(neighbor)){// check if visted
            shortestDistances.put(neighbor, curDistance + 1);
            if(endWord.equals(neighbor)){
              foundEnd = true;
            }else{
              queue.offer(neighbor);
            }
          }
        }
        if(foundEnd) break;
      }
    }


    for(int transformation = 0; transformation < wordList.size(); transformation++){
      while(!queue.isEmpty()){
        String curWord = queue.poll();
        if(endWord.equals(curWord)){ //destination found
          break;
        }else{
          // check if visted and check the distance to update the distance

          // create neighbors if needed
          /*if(!neighbors.containsKey(curWord)){
            neighbors.put(curWord, getNeighbors(curWord, dict));
          }*/

        }
      }
    }
  }

  private ArrayList<String> getNeighbors(String word, Set<String> dict){
    List<String> neighbors = new ArrayList<String>();

    char[] wordCharArr = word.toCharArray();

    for(int i = 0; i < word.length(); i++){
      for(char c = 'a'; c <= 'z'; c++) {
          if(wordCharArr[i] != c){
          char oldChar = wordCharArr[i];
          wordCharArr[i] = c;
          if(dict.contains(String.valueOf(wordCharArr))){
            neighbors.add(String.valueOf(wordCharArr));
          }
          wordCharArr[i] = oldChar;
        }
      }
    }
    return null;
  }

}

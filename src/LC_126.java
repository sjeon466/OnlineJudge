import java.util.*;

public class LC_126 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    String beginWord = sc.next();
    String endWord = sc.next();
    int numWords = sc.nextInt();
    List<String> wordList = new ArrayList<String>();
    LC_126 l = new LC_126();
    List<List<String>> resList = l.findLadders(beginWord, endWord, wordList);
    for(List<String> list : resList){
      System.out.println(Arrays.toString(list.toArray()));
    }
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    Set<String> dictionary = new HashSet<String>();
    List<List<String>> result = new ArrayList<List<String>>();

    HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();
    // Neighbors for every node.

    HashMap<String, Integer> distanceFromStartNode = new HashMap<String, Integer>();
    // Distance of every node from the start node

    List<String> solution = new ArrayList<String>();

    dictionary.add(beginWord);

    bfs(beginWord, endWord, dictionary, nodeNeighbors, distanceFromStartNode);


    return null;
  }

  // Trace to the endWord to record distance of each node from the beginWord
  private void bfs(String beginWord, String endWord, Set<String> dictionary, HashMap<String,ArrayList<String>> nodeNeighbors, HashMap<String,Integer> distanceFromStartNode) {
    // initializing the list
    for(String str : dictionary){
      nodeNeighbors.put(str, new ArrayList<String>());
    }

    Queue<String> queue = new LinkedList<String>();
    queue.offer(beginWord);
    distanceFromStartNode.put(beginWord, 0);

    while(!queue.isEmpty()){
      int count = queue.size();
      boolean foundend = false;

      for(int i = 0; i < count; i++){
        String curWord = queue.poll();
        int curDistance = distanceFromStartNode.get(curWord);
        ArrayList<String> neighbors = getNeighbors(curWord, dictionary);
        //nodeNeighbors.put(curWord, neighbors);

        for(String neighbor : neighbors){
          nodeNeighbors.get(curWord).add(neighbor);
          if(!distanceFromStartNode.containsKey(neighbor)){// check if visited
            distanceFromStartNode.put(neighbor, curDistance + 1);
            if(endWord.equals(neighbor)) { // found the shortest path
              foundend = true;
            }else{
              queue.offer(neighbor);
            }
          }
        }
        if(foundend){
          break;
        }
      }
    }
  }

  // DFS: output all paths with the shortest distance.
  private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
    solution.add(cur);
    if (end.equals(cur)) {
      res.add(new ArrayList<String>(solution));
    } else {
      for (String next : nodeNeighbors.get(cur)) {
        if (distance.get(next) == distance.get(cur) + 1) {
          dfs(next, end, dict, nodeNeighbors, distance, solution, res);
        }
      }
    }
    solution.remove(solution.size() - 1);
  }


  private ArrayList<String> getNeighbors(String curWord, Set<String> dictionary) {
    ArrayList<String> res = new ArrayList<String>();
    char[] curCharArr = curWord.toCharArray();
    for(char ch = 'a'; ch <= 'z'; ch++){
      for(int i = 0; i < curCharArr.length; i++){
        if(curCharArr[i] == ch) continue;
        char old_ch = curCharArr[i];
        curCharArr[i] = ch;
        if(dictionary.contains(String.valueOf(curCharArr))){
          res.add(String.valueOf(curCharArr));
        }
        curCharArr[i] = old_ch;
      }
    }
    return res;
  }


  private boolean createSolution(String curWord, String beginWord, String endWord, List<String>wordLIst, Set<String> wordMap, List<List<String>> resultLists , List<String> ansList, int curWordIndex, int curMoves){
    if(curMoves > wordLIst.size()) return false;

    if(curWord.equals(endWord)){
      ansList.add(curWord);
      resultLists.add(ansList);
      return true;
    }

    for(int i = curWordIndex; i < wordLIst.size(); i++){

    }



  /*    beginWord = "hit",
        endWord = "cog",
        wordList = ["hot","dot","dog","lot","log","cog"]

      Output:
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]*/
    return false;
  }

  private boolean jumpable(String strA, String strB){
    if(strA == null || strB == null || strA.length() != strB.length()) return false;
    int diffCount = 0;

    for(int i = 0; i < strA.length(); i++){
      if(strA.charAt(i) != strB.charAt(i)) {
        diffCount++;
        if(diffCount > 1){
          return false;
        }
      }
    }
    return true;
  }
}

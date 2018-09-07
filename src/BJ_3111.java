import java.util.Scanner;
import java.util.Stack;

public class BJ_3111 {
  public static void main(){
    Scanner sc = new Scanner(System.in );
    String keyWord = sc.next();
    String text = sc.next();

    Stack<Character> leftStk = new Stack<>();
    Stack<Character> rightStk = new Stack<>();

    int leftPointer = 0;
    int rightPointer = text.length() - 1;

    boolean isLeftTurn = true;

    while(leftPointer <= rightPointer){
      if(isLeftTurn){
        leftStk.push(text.charAt(leftPointer));
        // possible size
        if(leftStk.size() >= keyWord.length() && leftStk.peek() == keyWord.charAt(keyWord.length()-1)){
          Stack<Character> tempStk = new Stack<>();
          StringBuilder sb = new StringBuilder();

          for(int i = 0; i < keyWord.length(); i++){
            char curC = leftStk.pop();
            tempStk.push(curC);
            sb.append(curC);
          }

          // put it back if key is not found
          if(!sb.reverse().toString().equals(keyWord)){
            while(!tempStk.isEmpty()){
              leftStk.push(tempStk.pop());
            }
          }else{
            isLeftTurn = false;
          }
        }
        leftPointer++;
      }else{
        rightStk.push(text.charAt(rightPointer));
        // possible size
        if(rightStk.size() >= keyWord.length() && rightStk.peek() == keyWord.charAt(0)){
          Stack<Character> tempStk = new Stack<>();
          StringBuilder sb = new StringBuilder();

          for(int i = 0; i < keyWord.length(); i++){
            char curC = rightStk.pop();
            tempStk.push(curC);
            sb.append(curC);
          }

          // put it back if key is not found
          if(!sb.toString().equals(keyWord)){
            while(!tempStk.isEmpty()){
              rightStk.push(tempStk.pop());
            }
          }else{
            isLeftTurn = true;
          }
        }
        rightPointer--;
      }
    }



    while(!leftStk.isEmpty()){
      rightStk.push(leftStk.pop());
    }
    StringBuilder sb = new StringBuilder();
    while(!rightStk.isEmpty()){
      sb.append(rightStk.pop());
    }
    //System.out.println(sb.toString());
    //System.out.println("done");

    String almostAns = sb.toString();

    if(isLeftTurn){
      if(almostAns.indexOf(keyWord) != -1){
        // get rid of first occurance
        almostAns = almostAns.substring(0, almostAns.indexOf(keyWord)) +
        almostAns.substring(almostAns.indexOf(keyWord) + keyWord.length() ,
        almostAns.length());
      }
    }else {
      if(almostAns.lastIndexOf(keyWord) != -1){
        // get rid of last occurance
        almostAns = almostAns.substring(0, almostAns.lastIndexOf(keyWord)) +
                almostAns.substring(almostAns.lastIndexOf(keyWord) + keyWord.length(), almostAns.length());
      }
    }

    System.out.println(almostAns);



/*
    String[] nonKeyWords = text.split(keyWord);
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < nonKeyWords.length; i++){
      sb.append(nonKeyWords[i]);
    }

    System.out.println(sb.toString());

*/

    //System.out.println(keyWord + " " + text);

    //practice(text, keyWord);

/*
    while (true) {
      if(text.indexOf(keyWord) == -1){
        break;
      }else{
        // get rid of first occurance
        text = text.substring(0, text.indexOf(keyWord)) +
                text.substring(text.indexOf(keyWord) + keyWord.length() ,
                        text.length());
      }

      if(text.lastIndexOf(keyWord) == -1){
        break;
      }else{
        // get rid of last occurance
        text = text.substring(0, text.lastIndexOf(keyWord)) +
                text.substring(text.lastIndexOf(keyWord) + keyWord.length(), text.length());

      }
    }
    System.out.println(text);*/
  }

  private static void practice(String text, String keyWord){
    System.out.println(text + " with " + keyWord);
    // get rid of first occurance
    text = text.substring(0, text.indexOf(keyWord)) +
            text.substring(text.indexOf(keyWord) + keyWord.length() ,
                    text.length());
    System.out.println(text);
  }
}

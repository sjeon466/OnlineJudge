import java.util.Scanner;
import java.util.Stack;

public class BJ_9935 {

  static class Pair{
    //char c;
    int textIndex;
    int explosiveIndex;
    public Pair(int textIndex, int explosiveIndex){
      //this.c = c;
      this.textIndex = textIndex;
      this.explosiveIndex = explosiveIndex;
    }
  }

  public static void main(){
    Scanner sc = new Scanner(System.in);
    String text = sc.next();
    String explosive = sc.next();

    int textIndex = 0;
    Stack<Pair> stk = new Stack<>();
    boolean[] bombed = new boolean[text.length()];


    if(explosive.length() == 1){
      for(int i = 0; i < explosive.length(); i++){
        if(text.charAt(i) == explosive.charAt(0))
          bombed[i] = true;
      }
    }else{
      for(int i = 0; i < text.length(); i++){
        // adding first char of bomb
        if(text.charAt(i) == explosive.charAt(0)){
          stk.push(new Pair(i, 0));
        }else {
          if(!stk.isEmpty()){
            // some other char, but stack is not empty so that you can check
            if(text.charAt(i) == explosive.charAt(stk.peek().explosiveIndex + 1)){
              stk.push(new Pair( i, stk.peek().explosiveIndex +1));

              // if bomb is found on top of the stack.
              if(stk.peek().explosiveIndex == explosive.length() - 1){
                // pop bomb
                for(int j = 0; j < explosive.length(); j++){
                  bombed[stk.pop().textIndex] = true;
                }
              }
            }else{
              while(!stk.empty()){
                stk.pop();
              }
            }
          }else{
            // some other char, but stack empty you cannot check just continue
            continue;
          }
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < bombed.length; i++){
      if(bombed[i] == false) sb.append(text.charAt(i));
    }

    System.out.println(sb.toString());

    /*    while(true){
      String[] afterExplosion = text.split(explosive);
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < afterExplosion.length; i++){
        sb.append(afterExplosion[i]);
      }
      if(sb.length() == 0){
        System.out.println("FRULA");
        break;
      }
      text = sb.toString();
      if(text.indexOf(explosive) == -1){
        System.out.println(text);
        break;
      }
    }*/
  }
}

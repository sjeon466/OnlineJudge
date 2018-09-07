import java.util.Scanner;

public class BJ_11723 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numQueries = sc.nextInt();

    int num = 0; // empty set



    while(numQueries-- > 0) {
      String command = sc.next();
      if(command.equals("all")) {
        num = (1 << 20) - 1;
        /*for(int i = 0; i < 20; i++){
          num = num | (1 << i);
        }*/
        //System.out.println(command);
      }else if(command.equals("empty")){
        num = 0;
        //System.out.println(command);
      }else{
        int val = sc.nextInt();
        val--;
        if(command.equals("add")){
          num = num | (1 << val);
        }else if(command.equals("remove")){
          num =   num & ~(1 << val);

        }else if(command.equals("check")){
          if( (num & (1 << val)) != 0){
            System.out.println(0);
          }else{
            System.out.println(1);
          }
        }else if(command.equals("toggle")){
           num = num ^ (1 << val);
        }
        //System.out.println(command + " " + val);
      }
    }
    sc.close();
  }
}

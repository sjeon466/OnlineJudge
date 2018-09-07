/**
 * Created by sjeon on 4/19/2018.
 */

import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BackJoon_Editor {
    public static void main() throws IOException{
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        //String str = sc.next();

        Stack<Character> leftStk = new Stack<>();
        for(int i=0; i < str.length(); i++){
            leftStk.push(str.charAt(i));
        }
        Stack<Character> rightStk = new Stack<>();

        int numTC = Integer.parseInt(br.readLine());
        //System.out.println("numTC : " + numTC);
        //br.readLine();
        for(int i = 0; i < numTC; i++){

            String commandLine = br.readLine();
            //System.out.println("commandLine : " + commandLine);
            char command = commandLine.charAt(0);
            switch(command){
                case 'L':
                    if(!leftStk.isEmpty()){
                        rightStk.push(leftStk.pop());
                    }
                    break;
                case 'D':
                    if(!rightStk.isEmpty()){
                        leftStk.push(rightStk.pop());
                    }
                    break;
                case 'B':
                    if(!leftStk.isEmpty()){
                        leftStk.pop();
                    }
                    break;
                case 'P':
                    leftStk.push(commandLine.charAt(2));
                    break;
            }
        }
        /*Deque<Character> ansList = new LinkedList<>();
        while(!leftStk.isEmpty()){
            ansList.addFirst(leftStk.pop());
        }
        while(!rightStk.isEmpty()){
            ansList.addLast(rightStk.pop());
        }*/
        //System.out.println(ansList.toString());

        while(!leftStk.isEmpty()){
            rightStk.push(leftStk.pop());
        }
        //StringBuilder sb = new StringBuilder();
        while(!rightStk.isEmpty()){
            System.out.print(rightStk.pop());
            //sb.append(rightStk.pop());
        }
        //System.out.println(sb.toString());
    }
}

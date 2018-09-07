/**
 * Created by sjeon on 4/20/2018.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Deque;

import java.util.Queue;
public class BaekJoon_JosephusProblem {
    public static void main() throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String[] pieces = str.split(" ");

        int nPeople = Integer.parseInt(pieces[0]);
        int mThPerson = Integer.parseInt(pieces[1]);
        StringBuffer sb = new StringBuffer();

        //populate Queue
        Queue myQueue = new LinkedList();
        for(int i = 1; i <= nPeople; i++){
            myQueue.offer(i);
        }
        sb.append("<");

        while(!myQueue.isEmpty()){
            // pop m - 1 times and push m

            for(int i = 0; i < mThPerson - 1; i++){
                myQueue.offer(myQueue.poll());
            }
            sb.append((Integer)myQueue.poll() + ", ");
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb.append(">").toString());
    }
}

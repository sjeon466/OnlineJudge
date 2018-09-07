import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Created by sjeon on 4/3/2018.
 */
public class BackJoon_Meeting_Problem {

    public static void solve() throws IOException{
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numMeetings = Integer.parseInt(br.readLine()); //sc.nextInt();

        int points[][] = new int[numMeetings][2];

        for(int i = 0; i < points.length; i++) {
            String[] temp = br.readLine().split(" ");
            points[i][0] = Integer.parseInt(temp[0]);
            points[i][1] = Integer.parseInt(temp[1]);
        }

        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] p1, int[] p2){
                if(p1[1] == p2[1]){
                    return (p1[0] < p2[0]) ? -1 : 1;
                }else{
                    return Integer.compare(p1[1], p2[1]);
                }
            }
        });

        System.out.println(Arrays.deepToString(points));

        int ansCount = 0;
        int curEnd = -1;

        for(int i = 0; i < points.length; i++){
            if(points[i][0] >= curEnd){
                ansCount++;
                curEnd = points[i][1];
            }
        }
/*
        List<Meetup> meetups = new ArrayList<Meetup>();
        for(int i = 0; i < numMeetings; i++){
            meetups.add(new Meetup(sc.nextInt(), sc.nextInt()));
        }*/

    /*    for(Meetup temp : meetups){
            //System.out.println(temp.startT + " " + temp.endT);
        }*/
        //System.out.println();
        //System.out.println("SORT");
        //Collections.sort(meetups, new SortByEndingTime());
        //System.out.println();

/*        for(Meetup temp : meetups){
            //System.out.println(temp.startT + " " + temp.endT);
        }*/

/*        int ans = 1;
        int curEnd = meetups.get(0).endT;

        for(int i = 1; i < meetups.size(); i++){
            if(meetups.get(i).startT >= curEnd){
                ans++;
                curEnd = meetups.get(i).endT;
            }
        }*/
        System.out.println(ansCount);
    }
}

class SortByEndingTime implements Comparator<Meetup>{
    @Override
    public int compare(Meetup m1, Meetup m2){
        if(m1.endT == m2.endT){
            return (m1.startT > m2.startT) ? 1 : -1;
        }else{
            return (m1.endT > m2.endT) ? 1 : -1;
        }
    }
}

class Meetup implements Comparable<Meetup>{
    int startT = 0;
    int endT = 0;

    public Meetup(){}

    public Meetup(int sT, int eT){
        this.startT = sT;
        this.endT = eT;
    }

    @Override
    public int compareTo(Meetup o) {
        return this.startT;
    }

}

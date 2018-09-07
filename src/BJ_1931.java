import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
class Meeting implements Comparable<Meeting>{
  int startTime;
  int endTime;
  public Meeting(int startTime, int endTime){
    this.startTime = startTime;
    this.endTime = endTime;
  }
  @Override
  public String toString(){
    return ("(" + startTime + " -> " + endTime + ")");
  }

  @Override
  public int compareTo(Meeting meeting) {
    if(this.endTime == meeting.endTime){
      return this.startTime - meeting.startTime;
    }else{
      return this.endTime - meeting.endTime;
    }
  }
}
public class BJ_1931 {
  private static Scanner sc = new Scanner(System.in);
  public static void main(){
    int numMeetings = sc.nextInt();
    Meeting[] meetings = new Meeting[numMeetings];
    for(int i=0; i < numMeetings; i++){
      meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
    }
    //System.out.println(Arrays.toString(meetings));
    //System.out.println("SORT");
    Arrays.sort(meetings);
    //System.out.println(Arrays.toString(meetings));

    int meetingCount = 1;
    int curEndTime = meetings[0].endTime;
    for(int i=1; i<numMeetings; i++){
      if(meetings[i].startTime >= curEndTime){
        meetingCount++;
        curEndTime = meetings[i].endTime;
      }
    }
    System.out.println(meetingCount);
  }
}

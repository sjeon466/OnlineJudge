import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_2261{
  static class Point{
    int x;
    int y;
    public Point(int x, int y){
      this.x = x;
      this.y = y;
    }
  }

  static int numPoints;
  static Point[] points;

  private static long getDistance(Point p1, Point p2){
    return (long) (Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y-p2.y), 2));
  }

  public BJ_2261() {
  }

  private static long getMinDistance(int start, int end){
    long minDist = Long.MAX_VALUE;

    int mid = (start + end) / 2;
    int size = end - start + 1;

    if(size == 2 ){
      return getDistance(points[start], points[end]);
    } else if(size == 3){
      long dist1 = getDistance(points[0], points[1]);
      long dist2 = getDistance(points[0], points[2]);
      long dist3 = getDistance(points[1], points[2]);
      return Math.min(dist1 , Math.min(dist2, dist3));
    }

    long leftMin = getMinDistance(start, mid);
    long rightMin = getMinDistance(mid + 1, end);

    minDist = Math.min(leftMin, rightMin);

    Point[] tempPoints = new Point[end - start + 1];
    int midSize = 0;



    for(int i = start; i < end; i++){
      for(int j = i + 1; j < end; j++){
        long curDist = getDistance( points[i], points[j]);
          if(curDist < minDist){
            minDist = curDist;
          }
      }
    }
    return 0;

  }

}




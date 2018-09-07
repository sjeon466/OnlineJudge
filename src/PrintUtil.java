import java.util.Arrays;
import java.util.List;

/**
 * Created by sjeon on 3/18/2018.
 */
public class PrintUtil {
    public static void printNestedArrayList(List<List<Integer>> list){
        for(List tempList : list){
            System.out.println(Arrays.toString(tempList.toArray()));
        }
    }
}

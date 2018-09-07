import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class HR_Algo_StrongPassWord {

  // Complete the minimumNumber function below.
  static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong

    int neededCount = 0;
    int curCount = n;
    if(!containsLowerCase(password)){
      neededCount++;
    }
    if(!containsUpperCaseRegex(password)){
      neededCount++;
    }
    if(!containsSpecialCaseRegex(password)){
      neededCount++;
    }
    if(!containsDigitsRegex(password)){
      neededCount++;
    }
    return (neededCount > (6 - curCount) ? neededCount : (6 - curCount));
  }

  private static boolean containsDigitsRegex(String password){
    Pattern myPattern = Pattern.compile("[0-9]");
    Matcher myMatcher = myPattern.matcher(password);

    while(myMatcher.find()){
      //System.out.println("myMatcher.start()" + "myMatcher.end()" + myMatcher.group());
      return true;
    }
    return false;
  }


  private static boolean containsSpecialCaseRegex(String password) {
    Pattern myPattern = Pattern.compile("[-!@#$%^&*()+]");
    Matcher myMatcher = myPattern.matcher(password);

    while(myMatcher.find()){
      //System.out.println("Start Index :" + myMatcher.start() + ", End Index : " + myMatcher.end());
      //System.out.println(myMatcher.group());
      return true;
    }
    return false;
  }

  private static boolean containsLowerCase(String password){
    boolean containsLC = false;
    for(int i=0; i < password.length(); i++){
      if(Character.isLowerCase(password.charAt(i))){
        return true;
      }
    }
    return false;
  }

  private static boolean containsUpperCase(String password){
    return !password.equals( password.toLowerCase());
  }

  private static boolean containsUpperCaseRegex(String password){
    final String pass = password;
    Pattern myPattern = Pattern.compile("[A-Z]");
    Matcher myMatcher = myPattern.matcher(pass);

    while(myMatcher.find()){
      System.out.println("Start Index = " + myMatcher.start() +
              ", Ending Index = " + myMatcher.end() );
      System.out.println(myMatcher.group());
      return true;
    }
    return false;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main() throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String password = scanner.nextLine();

    int answer = minimumNumber(n, password);
    System.out.println("Answer = " + answer);

    bufferedWriter.write(String.valueOf(answer));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}

import java.util.*;
import java.io.*;

public class q10872 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int a = Integer.parseInt(br.readLine());

    int sum = factorial(a);

    System.out.println(sum);
  }

  public static int factorial(int a) {
    if(a <= 1) return 1;
    return a*factorial(a-1);
  }
}
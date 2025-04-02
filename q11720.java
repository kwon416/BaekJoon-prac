import java.util.*;

public class q11720 {
    public static void main(String args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String sNum = sc.nextLine();

        char[] chars = sNum.toCharArray();

        int sum = 0;

        for (int i = 0; i < chars.length; i++) {
            sum += (int) chars[i];
        }
        System.out.print(sum);

    }
}

package silver;

import java.util.*;

public class q1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();
        int ans = 0;

        String[] sts = st.split("-");

        for (int i = 0; i < sts.length; i++) {
            int temp = mySum(sts[i]);
            if (i == 0) ans = temp;
            else ans -= temp;
        }
        System.out.println(ans);
    }

    public static int mySum(String st) {
        String[] sts = st.split("[+]");
        int temp = 0;
        for (int i = 0; i < sts.length; i++) {
            temp += Integer.parseInt(sts[i]);
        }
        return temp;
    }

}

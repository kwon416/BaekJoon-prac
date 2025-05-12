package bronze;

import java.util.*;

public class q5597 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[30];

        for(int i = 0; i < 28; i++) {
            int a = sc.nextInt();
            arr[a-1] = 1;
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) System.out.println(i+1);
        }
    }
}

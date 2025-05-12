package bronze;

import java.io.*;
public class q9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            System.out.print(s.charAt(0));
            System.out.println(s.charAt(s.length()-1));
        }
        br.close();
    }
}

import java.io.*;

public class q27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());

        System.out.print(s.charAt(i-1));

        br.close();
    }
}

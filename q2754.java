import java.io.*;

public class q2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        double grade = 0;
        switch (s.charAt(0)) {
            case 'A' : grade = 4; break;
            case 'B' : grade = 3; break;
            case 'C' : grade = 2; break;
            case 'D' : grade = 1; break;
            case 'F' : {
                System.out.println("0.0");
                return;
            }
        }
        char c = s.charAt(1);
        if(c == '+') grade += 0.3;
        else if(c == '-') grade -= 0.3;

        System.out.println(grade);

    }
}

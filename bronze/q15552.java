package bronze;

import java.io.*;
import java.util.StringTokenizer;

public class q15552 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st;

    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      if(!st.hasMoreTokens()) break;
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      bw.write((a+b)+"\n");
    }
    br.close();
    
    bw.flush();
    
    bw.close();
  }
}

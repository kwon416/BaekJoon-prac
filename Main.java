import java.time.*;
public class Main {
  public static void main(String[] args) {

    LocalDate now = LocalDate.now();

    now = now.minusDays(1);
    System.out.println(now);

  }
}
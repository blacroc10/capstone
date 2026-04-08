// jack is always excited about sunday, everytime month starts, he counts number of sunday he enjoys, considering the month can start with any day,count the number of sunday given in n days.
import java.util.*;

public class SIT_106 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of days:");
    int D = sc.nextInt();

    System.out.print("Enter the starting day of the week:");
    String day = sc.next();

    String[] daysOfWeek = {
        "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday", "Sunday"
    };

    int startIndex = -1;

    for (int i = 0; i < 7; i++) {
      if (daysOfWeek[i].equalsIgnoreCase(day)) {
        startIndex = i;
        break;
      }
    }

    if (startIndex == -1) {
      System.out.println("Invalid day");
    }

    int offset = (6 - startIndex + 7) % 7;

    int count = 0;

    if (offset < D) {
      count = 1 + (D - offset - 1) / 7;
    }

    System.out.println("Number of Sundays: " + count);

    sc.close();
  }
}
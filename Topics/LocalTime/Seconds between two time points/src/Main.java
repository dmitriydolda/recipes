import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here

        int time1 = LocalTime.parse(scanner.nextLine()).toSecondOfDay();
        int time2 = LocalTime.parse(scanner.nextLine()).toSecondOfDay();

        System.out.println(Math.abs(time2 - time1));
    }
}
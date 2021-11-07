import java.time.LocalDateTime;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.HOURS;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        LocalDateTime localDateTime1 = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime localDateTime2 = LocalDateTime.parse(scanner.nextLine());

        System.out.println(HOURS.between(localDateTime1, localDateTime2));;
    }
}
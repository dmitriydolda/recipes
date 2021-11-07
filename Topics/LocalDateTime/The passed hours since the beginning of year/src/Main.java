import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        LocalDateTime localDateTime = LocalDateTime.parse(scanner.nextLine());

        LocalDate date = LocalDate.of(localDateTime.getYear(), 1, 1);
        LocalTime time = LocalTime.of(0, 0);

        int dateDiff = (int) date.until(localDateTime.toLocalDate(), ChronoUnit.DAYS) * 24;
        int timeDiff = (int) time.until(localDateTime.toLocalTime(), ChronoUnit.HOURS);
        System.out.println(dateDiff + timeDiff);
    }
}
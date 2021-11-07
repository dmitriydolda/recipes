import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String dateString = scanner.nextLine();

        LocalDate date = LocalDate.parse(dateString.substring(0, dateString.indexOf('T')));
        LocalTime time = LocalTime.parse(dateString.substring(dateString.indexOf('T') + 1));

        LocalDateTime localDateTime = LocalDateTime.of(date, time);
        localDateTime = localDateTime.plusHours(11);

        System.out.println(localDateTime.toLocalDate());
    }
}
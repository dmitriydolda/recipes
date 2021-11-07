import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        LocalDateTime localDateTime = LocalDateTime.parse(scanner.nextLine());

        String[] input = scanner.nextLine().split(" ");
        int hoursToSub = Integer.parseInt(input[0]);
        int minutesToAdd = Integer.parseInt(input[1]);

        localDateTime = localDateTime.minusHours(hoursToSub).plusMinutes(minutesToAdd);

        System.out.println(localDateTime);
    }
}
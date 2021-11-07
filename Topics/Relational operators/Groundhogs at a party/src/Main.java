import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int numCups = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();

        if (!isWeekend && numCups >= 10 && numCups <= 20) {
            System.out.println("true");
        } else if (isWeekend && numCups >= 15 && numCups <= 25) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
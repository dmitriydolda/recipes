import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCount = 4;
        for (int i = 0; i < numberCount; i++) {
            int number = scanner.nextInt();
            number--;
            System.out.print(number + " ");
        }
    }
}

import java.util.*;
import java.util.stream.Collectors;

class ConcatPositiveNumbersProblem {

    public static ArrayList concatPositiveNumbers(ArrayList<Integer> l1, ArrayList<Integer> l2) {

        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(l1);
        result.addAll(l2);


        return new ArrayList<Integer>(List.of(l1.stream().filter(val -> val >= 0), l2.stream().filter(val -> val >= 0)));// write your code here
    }

    /* Do not modify this method */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list1 = readArrayList(scanner);
        ArrayList<Integer> list2 = readArrayList(scanner);

        ArrayList<Integer> result = concatPositiveNumbers(list1, list2);

        result.forEach(n -> System.out.print(n + " "));
    }

    /* Do not modify this method */
    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
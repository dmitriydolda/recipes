import java.util.Arrays;
import java.util.List;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        // implement the method
        long sameNumberList1 = list1.stream().filter(integer -> integer == elem).count();
        long sameNumberList2 = list2.stream().filter(integer -> integer == elem).count();

        return sameNumberList1 == sameNumberList2;
    }
}
import com.sun.source.tree.Tree;

import java.util.*;

public class Main {

    public static void main(String[] args) {    
        // write your code here
        HashMap<Integer, String> map = new HashMap<>(16);
        map.put(45, "The King");

        Integer x = 45;
        System.out.println(x.hashCode());

        System.out.println(map);
    }
}
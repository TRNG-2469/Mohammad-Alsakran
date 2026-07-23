package Week1.Thursday.CollectionsPractice.coll;

import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();


        set.add("Frank");
        set.add("Kevin");
        set.add("Diana");
        set.add("Adam");
        set.add("Kevin"); // Duplicate, will not be added
        System.out.println(set);



    }
}
// Hashset ---> [Diana, Adam, Kevin, Frank] Can contain null values, does not maintain order
// linkedHashSet --> [Frank, Kevin, Diana, Adam] Maintains insertion order, can contain null values
// TreeSet --> [Adam, Diana, Frank, Kevin] Maintains sorted order, cannot contain null values
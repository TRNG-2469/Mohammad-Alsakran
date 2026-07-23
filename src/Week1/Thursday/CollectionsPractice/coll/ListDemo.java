package Week1.Thursday.CollectionsPractice.coll;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {


        List <String>  list= new ArrayList<>();
        list.add("Kevin");
        list.add("Bob");
        list.add("Alice");
        //list.add(new Integer(5));

        System.out.println(list);


        //list.remove("a");
        System.out.println(list.contains('b'));
        System.out.println(list);


        //Collection.sort(list, Collections.reverseOrder());
        System.out.println(list);

    }
}

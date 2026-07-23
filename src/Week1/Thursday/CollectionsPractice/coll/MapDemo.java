package Week1.Thursday.CollectionsPractice.coll;

import java.util.HashMap;
import java.util.Map;


public class MapDemo   {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("Jon", 10000);
        map.put("Surya", 11000);
        map.put("Daquan", 12000);
        map.put("Jon", 13000); // This will overwrite the previous value for "Jon"

        System.out.println(map);
        System.out.println(map.get("Jon")); // This will print the value for "Jon"




        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        for (Map.Entry<String, Integer> entry:map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

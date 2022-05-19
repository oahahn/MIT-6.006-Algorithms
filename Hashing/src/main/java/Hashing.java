import java.util.ArrayList;
import java.util.HashMap;

public class Hashing {
    public static int h(int k) {
        return (11 * k + 4) % 9;
    }

    public static HashMap<Integer, ArrayList<Integer>> createHashMap(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int key = h(arr[i]);
            hmap.putIfAbsent(key, new ArrayList<>());
            hmap.get(key).add(arr[i]);
        }
        return hmap;
    }
}

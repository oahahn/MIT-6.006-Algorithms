import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class HashingTest {

    @Test
    void createHashMap() {
        // Create result manually
        HashMap<Integer, ArrayList<Integer>> expectedMap = new HashMap<>();
        ArrayList<Integer> al1 = new ArrayList<>(Arrays.asList(67, 13, 49, 40, 58));
        expectedMap.put(3, al1);
        ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(24, 33));
        expectedMap.put(7, al2);
        // Use function
        int[] list = {67, 13, 49, 24, 40, 33, 58};
        HashMap<Integer, ArrayList<Integer>> result = Hashing.createHashMap(list);
        assertEquals(expectedMap, result);
    }
}
package other;

import java.util.HashMap;
import java.util.Map;

public class FindNumsAppearOnce {
    public static void FindNumsAppearOnce(int [] array, int [] num1, int [] num2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])){
                map.remove(array[i]);
            } else {
                map.put(array[i], 1);
            }
        }

        int index = 0;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            index++;
            if(index == 1) {
                num1[0] = entry.getKey();
            } else {
                num2[0] = entry.getKey();
            }
        }
    }
}

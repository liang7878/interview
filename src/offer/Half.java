package offer;

import java.util.Arrays;

public class Half {
    public static void main(String[] args) {
        Half half = new Half();


    }

    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);

        return array[array.length/2];
    }
}

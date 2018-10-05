package interview;

import java.util.*;

public class Qunar1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String [] arr = in.nextLine().split(" ");

        int [] nums = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        int max = Integer.MIN_VALUE;
        int curMax = 0;

        for (int i = 0; i < nums.length; i++) {
            if(curMax <= 0) {
                curMax = nums[i];
            }else{
                curMax += nums[i];
            }

            if(max<curMax) max=curMax;
        }

        System.out.println(max);
    }
}

package leetcode.question703;

import java.util.ArrayList;
import java.util.Arrays;

public class KthLargest {
    private ArrayList<Integer> objs;
    private int K;

    public static void main(String[] args){
        int k = 3;
        int[] arr = new int[]{-2};
        KthLargest kthLargest = new KthLargest(1, arr);
        int a = kthLargest.add(-3);   // returns 4
        int b = kthLargest.add(0);   // returns 5
        int c = kthLargest.add(2);  // returns 5
        int d = kthLargest.add(-1);   // returns 8
        int e = kthLargest.add(4);   // returns 8

    }

    public KthLargest(int k, int[] nums) {
        this.objs = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = nums.length-1; i >= 0 ; i--) {
            this.objs.add(nums[i]);
        }

        this.K = k;
    }

    public int add(int val) {
        if(objs.size() == 0) {
            objs.add(val);
        }

        for (int i = 0; i < objs.size(); i++) {
            if(objs.get(i) > val && i!=objs.size()-1) continue;
            if(i==objs.size()-1 && objs.get(i) > val) {
                objs.add(val);
            } else {
                objs.add(i, val);
                break;
            }
        }

        return objs.get(this.K-1);
    }
}

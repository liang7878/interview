package interview.bytedance;

import java.util.Scanner;

public class Solution5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int [] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(getZuhe(arr, 0, arr.length-1));

    }

    //1 2 3  123
    //1 3 2  213
    //2 1 3  123
    //2 3 1  123
    //3 1 2  213
    //3 2 1 123

    // 1 6 1 2     6 1

    public static long getZuhe(int [] arr, int start, int end) {
        if(start == end) {
            return 1l;
        }

        if(start < end) {
            if(arr[end] < arr[start]) {
                return 0l;
            } else {
                return (getZuhe(arr, start+1, end) + getZuhe(arr, start, end-1))%12345678;
            }
        }

        return 0l;
    }
}

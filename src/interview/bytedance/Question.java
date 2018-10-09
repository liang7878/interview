package interview.bytedance;

import java.util.HashSet;
import java.util.Scanner;

public class Question {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        HashSet<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);

        int min = a>b?b:a;
        int max = a>b?a:b;

        long k = in.nextLong();

        long count = 0l;

        for (long i = min*k; i < max*k+1; i++) {
            if(!judge(i, set)) continue;
            if(helper(i, a, b, k)) count++;
        }

        System.out.println(count);
    }

    public static boolean helper(long i, int a, int b, long k) {
        if(i>0 && k>0) {
            return helper(i-a, a, b, k-1) || helper(i-b, a, b, k-1);
        }

        if(i==0 && k==0) {
            return true;
        } else if(i < 0) {
            return false;
        }

        return false;
    }

    private static boolean judge(long sum, HashSet<Integer> set) {
        if (sum == 0) return false;

        String str = String.valueOf(sum);
        for (int i = 0; i < str.length(); i++) {

            if (!set.contains(Integer.parseInt(str.substring(i, i+1))))
                return false;

        }

        return true;
    }
}

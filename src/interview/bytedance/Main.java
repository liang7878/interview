package interview.bytedance;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private long count = 0;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        HashSet<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);

        long k = in.nextLong();
        Main solution = new Main();
        solution.helper(0l, 0l, k, set, a, b);
        System.out.println(solution.count);
    }

    public void helper(long sum, long index, long k, HashSet<Integer> set, int a, int b) {
        if(index == k) {
            if(judge(sum, set)) count++;
            return;
        }

        helper(sum+a, index+1, k, set, a, b);
        helper(sum+b, index+1, k, set, a, b);
    }

    private boolean judge(long sum, HashSet<Integer> set) {
        if (sum == 0) return false;

        String str = String.valueOf(sum);
        for (int i = 0; i < str.length(); i++) {

            if (!set.contains(Integer.parseInt(str.substring(i, i+1))))
                return false;

        }

        return true;
    }

}

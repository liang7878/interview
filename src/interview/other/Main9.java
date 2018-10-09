package interview.other;

import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String [] tmps = in.nextLine().split(",");

        int [] table = new int[tmps.length];

        for (int i = 0; i < tmps.length; i++) {
            table[i] = Integer.parseInt(tmps[i]);
        }


        int[] dp = new int[table.length+1];

        for (int i = 0; i < dp.length; i++) {
            if(i==0 || i==1) {
                dp[i] = table[i];
                continue;
            }

            dp[i] = Math.min(dp[i-1] + table[i-1], dp[i-2]+table[i-2]);
        }

        if(table.length == 2) {
            System.out.println(Math.min(table[0], table[1]));
        } else {
            System.out.println(dp[table.length-1]);
        }

    }

}

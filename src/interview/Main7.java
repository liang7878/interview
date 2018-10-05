package interview;

import java.util.Scanner;

/*
*
*
5
1 4 1
2 5 1
2 2 2
9 9 9
1 3 5
*
*
* */


public class Main7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        int[] mark = new int[n+1]; //合格为0，不合格为1
        long[][] goods = new long[n+1][3];
        mark[0] = 0;
        goods[0][0] = Long.MAX_VALUE;
        goods[0][1] = Long.MAX_VALUE;
        goods[0][2] = Long.MAX_VALUE;

        for (int i = 1; i <n+1 ; i++) {
            String[] canshulist = in.nextLine().split(" ");
            goods[i][0] = Long.parseLong(canshulist[0]);
            goods[i][1] = Long.parseLong(canshulist[1]);
            goods[i][2] = Long.parseLong(canshulist[2]);

            dp[i] = Math.max(dp[i-1], getCount(goods, mark, i));
        }

        System.out.println(dp[n]);
    }

    public static int getCount(long[][] goods, int[] mark, int added) {
        int count = 0;
        for (int i = 1; i < added+1; i++) {
            if(mark[i] == 0) {
                if(goods[i][0] < goods[added][0] && goods[i][1] < goods[added][1] && goods[i][2] < goods[added][2]) {
                    count++;
                    mark[i] = 1;
                } else if(goods[i][0] > goods[added][0] && goods[i][1] > goods[added][1] && goods[i][2] > goods[added][2]) {
                    if(mark[added] == 0) {
                        mark[added] = 1;
                    }
                }
            } else {
                if(goods[i][0] > goods[added][0] && goods[i][1] > goods[added][1] && goods[i][2] > goods[added][2]) {
                    if(mark[added] == 0) {
                        mark[added] = 1;
                    }
                }
                count++;
            }
        }

        return count;
    }
}

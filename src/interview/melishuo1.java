package interview;

import java.util.Scanner;

public class melishuo1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int dp[][] = new int[11][11];
        dp[0][0] = 0;
        for(int i=0; i<=x; i++)
            dp[i][0] = 1;
        for(int i=0; i<=y; i++)
            dp[0][i] = 1;
        for(int i=1; i<=x; i++){
            for(int j=1; j<=y; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
        System.out.print(dp[x][y]);
    }


}

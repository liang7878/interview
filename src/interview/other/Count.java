package interview.other;

public class Count {
    public static void main(String[] args) {
        Count c = new Count();
        System.out.println(c.getCount(3));
    }

    public int getCount(int n) {
        if(n == 1 || n==2) return n;

        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

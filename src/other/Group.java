package other;

import java.math.BigDecimal;
import java.util.Scanner;

public class Group {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        long k = in.nextLong();

        long group = getGroup(n, m);

        if(k>group){
            System.out.println(-1);
            return;
        }

        printWord(n, m, group, k);

    }

    static void printWord(int n, int m, long group, long k) {
        if(n==0) {
            for (int i = 0; i < m; i++) {
                System.out.print("z");
                m--;
            }
            return;
        }

        if(m == 0) {
            for (int i = 0; i <n ; i++) {
                System.out.print("a");
                n--;
            }
            return;
        }

        long result = getGroup(n-1, m);
        if(k<=result) {
            System.out.print("a");
            printWord(n-1, m, result, k);
        } else {
            System.out.print("z");
            printWord(n, m-1, group-result, k-result);
        }
    }

    public static long getGroup(int n, int m) {
//        long nResult = 1;
//        long mResult = 1;
//        long sumResult = 1;

        BigDecimal nResult = new BigDecimal(1);
        BigDecimal mResult = new BigDecimal(1);
        BigDecimal sumResult = new BigDecimal(1);

        for (int i = 1; i <= n; i++) {
            nResult = nResult.multiply(new BigDecimal(i));
        }

        for (int i = 1; i <= m; i++) {
            mResult = mResult.multiply(new BigDecimal(i));
        }

        for (int i = 1; i <= (n+m); i++) {
            sumResult = sumResult.multiply(new BigDecimal(i));
        }

        return sumResult.divide(nResult).divide(mResult).longValue();
    }
}

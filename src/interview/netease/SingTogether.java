package interview.netease;

import java.util.Scanner;

public class SingTogether {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] stus = new int[N];
        for(int i=0; i<N; i++) {
            stus[i] = in.nextInt();
        }

        int K = in.nextInt();
        int D = in.nextInt();
        long res = Integer.MIN_VALUE;

//        int[] result = new int[n+1];
        long[][] fmax = new long[N+1][K+1];
        long[][] fmin = new long[N+1][D+1];

        for(int i=1; i<=N; i++) {
            fmin[i][1] = stus[i];
            fmax[i][1] = stus[i];

            for(int k=2; k<=K; k++) {
                for(int j=i-1; j>0 && i-j<=D; j--) {
                    fmax[i][k] = Math.max(fmax[i][k], Math.max(fmax[j][k-1] * stus[i], fmin[j][k-1] * stus[i]));
                    fmin[i][k] = Math.max(fmin[i][k], Math.min(fmax[j][k-1] * stus[i], fmin[j][k-1] * stus[i]));
                }
            }

            res = Math.max(res, fmax[i][K]);
        }

        System.out.println(res);
    }
}

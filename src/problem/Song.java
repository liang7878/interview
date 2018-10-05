package problem;

import java.util.Scanner;

public class Song {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int K = in.nextInt();
        int A = in.nextInt();
        int X = in.nextInt();
        int B = in.nextInt();
        int Y = in.nextInt();

        System.out.println(getCount(K,A,X,B,Y)%1000000007);
    }

    public static long getCount(int K, int A, int X, int B, int Y) {
        if(K==0) return 0;
        if(K<A&&K<B) return 0;
        if(X<=0&&Y<=0) return 0;
        if(K==A) return X;
        if(K==B) return Y;

        long[] dp = new long[K];

        for(int i=1; i<X+Y+1; i++) {
            for (int j = 1; j < K+1; j++) {

            }
        }

        return X*getCount(K-A, A, X-1, B, Y) + Y*getCount(K-B, A, X, B, Y-1);
    }
}

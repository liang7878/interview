package interview.other;

import java.util.Scanner;

public class Main13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long N = Long.parseLong(in.nextLine());
        boolean flag = true;
        
        long minMul = nlcm(1, N);
        long M =N;
        
        while(flag) {
            M++;
            if(minMul%M == 0) {
                long test = nlcm(N+1, M);
                if(minMul == nlcm(N+1, M)) {
                    break;
                }
            } else {
                minMul = lcm(minMul, M);
            }
        }

        System.out.println(M);

    }
    
    public static long nlcm(long start, long end) {
        long result = start;
        for (long i = start + 1; i <=end ; i++) {
            result = lcm(result, i);
        }

        return result;
    }

    public static long gcd(long p, long q) {
        if(q == 0) return p;
        return gcd(q, p%q);
    }

    public static long lcm(long p, long q) {
        long pq = p*q;
        return pq / gcd(p,q);
    }

}

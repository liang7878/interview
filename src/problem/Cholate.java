package problem;

import java.util.Scanner;

public class Cholate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        System.out.println(getMaxCho(N, M));;
    }

    public static int getMaxCho(int n, int m) {
        if(n==1) {
            return m;
        }

        return 0;
    }
}

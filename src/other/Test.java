package other;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long x = in.nextLong();
        long y = in.nextLong();
        long n = in.nextLong();
        Double result = Math.pow(x, y)%n;

        System.out.println(result.longValue());
    }
}

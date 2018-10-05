package other;

import java.util.Scanner;

public class mark {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        if(a == 1) {
            System.out.println((a+b)*c);
            return;
        }

        if(b == 1) {
            if((a+b)*c > a*(b+c)) {
                System.out.println((a+b)*c);
                return;
            } else {
                System.out.println(a*(b+c));
                return;
            }
        }

        if(c == 1) {
            System.out.println(a*(b+c));
            return;
        }

        System.out.println(a*b*c);
    }
}

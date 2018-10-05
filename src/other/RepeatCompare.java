package other;

import java.util.Scanner;

public class RepeatCompare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long x1 = in.nextLong();
        int  k1 = in.nextInt();
        long x2 = in.nextLong();
        int k2 = in.nextInt();

        char [] x1char = String.valueOf(x1).toCharArray();
        char [] x2char = String.valueOf(x2).toCharArray();

        if(x1char.length*k1 > x2char.length*k2) {
            System.out.println("Greater");
        } else if(x1char.length*k1 < x2char.length*k2) {
            System.out.println("Less");
        } else {
            char [] newX1 = new char[x1char.length*k1];
            char [] newX2 = new char[x2char.length*k2];


            for (int i = 0; i < k1; i++) {
                for (int j = 0; j < x1char.length; j++) {
                    newX1[i*x1char.length+j] = x1char[j];
                }
            }

            for (int i = 0; i < k2; i++) {
                for (int j = 0; j < x2char.length; j++) {
                    newX2[i*x2char.length+j] = x2char[j];
                }
            }

            for (int i = 0; i < newX1.length; i++) {
                if(newX1[i] == newX2[i]) {
                    continue;
                } else if(newX1[i] > newX2[i]) {
                    System.out.println("Greater");
                    return;
                } else {
                    System.out.println("Less");
                    return;
                }
            }
            System.out.println("Equal");
        }
    }
}

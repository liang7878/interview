package interview.other;

import java.util.Scanner;

public class Main16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());

        for (int i = 0; i < T; i++) {
            System.out.println(Math.random());
            if(Math.random() > 0.4) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

//        Thread test = new

//        Main16 tets = new Main16();
//        System.out.println(tets.Main16(1));
    }

    public int Main16(int test) {
        return 0;
    }
}

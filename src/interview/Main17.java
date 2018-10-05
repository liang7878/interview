package interview;

import java.util.Arrays;
import java.util.Scanner;

public class Main17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] garr = in.nextLine().split(" ");

        int [] g = new int[garr.length];

        for (int i = 0; i < garr.length; i++) {
            g[i] = Integer.parseInt(garr[i]);
        }


        String[] sarr = in.nextLine().split(" ");

        int [] s = new int[sarr.length];
        for (int i = 0; i < sarr.length; i++) {
            s[i] = Integer.parseInt(sarr[i]);
        }

        Arrays.sort(s);
        Arrays.sort(g);

        int gindex = g.length-1;
        int sindex = s.length-1;

        int manzu = 0;

        for (int i = s.length-1; i >= 0; i--) {
            while(gindex > -1 && g[gindex] > s[i]) gindex--;
            if(gindex == -1) break;
            manzu++;
            gindex--;
        }

        System.out.println(manzu);
    }
}

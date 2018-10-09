package interview.other;

import java.util.ArrayList;
import java.util.Scanner;

public class Main8 {
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] ab = in.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);

        System.out.println(getString(a, b));
    }

    public static String getString(int a, int b) {
        if(a%b==0) {
            return String.valueOf(a/b);
        }

        int [] yushu = new int[110];
        int [] xiaoshu = new int[110];

        yushu[0] = a%b;

        result.append(a/b);
        result.append(".");

        int lkuohao = 0;
        int rkuohao = 0;
        int zuokuohao = 0;
        int i, j;
        while(true) {
            if(rkuohao == 100) {
                yushu[lkuohao] = -1;
                break;
            }
            xiaoshu[rkuohao++] = yushu[lkuohao] * 10 / b;
            yushu[lkuohao+1] = yushu[lkuohao] *10 % b;
            lkuohao++;
            if(yushu[lkuohao-1] *10 % b == 0) {
                yushu[lkuohao] = -1;
                break;
            }

            zuokuohao = existYushu(yushu, lkuohao);

            if(zuokuohao != lkuohao) {
                break;
            }
        }

        if(yushu[lkuohao] == -1) {
            for (i=0; i<rkuohao; i++) {
                result.append(xiaoshu[i]);
            }
        } else {
            if(zuokuohao!=lkuohao) {
                for (int k = 0; k < zuokuohao; k++) {
                    result.append(xiaoshu[k]);
                }
                result.append("(");
                for (i = zuokuohao; i < rkuohao; i++) {
                    result.append(xiaoshu[i]);
                }
                result.append(")");
            } else {
                result.append("(");
                for (i = 0; i < rkuohao; i++) {
                    result.append(xiaoshu[i]);
                }
                result.append(")");
            }


        }

        return result.toString();
    }

    public static int existYushu(int [] yushu, int n) {
        int result = n;
        for (int i = 0; i < n; i++) {
            if(yushu[i] == yushu[n]) {
                result = i;
            }
        }

        return result;
    }
}

package interview.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class pdd3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String [] line1 = in.nextLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(line1[1]);
        int [] prices = new int[N];
        String [] line2 = in.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(line2[i]);
        }

        int [] X = new int[M];
        int [] Y = new int[M];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            String [] line3 = in.nextLine().split(" ");
            X[i] = Integer.parseInt(line3[0]);
            Y[i] = Integer.parseInt(line3[1]);
            map.put(X[i], Y[i]);
        }

        Arrays.sort(X);
        int fa = X[X.length-1]+1;
        int [] priceSeq = new int[fa];

        int current = -1;
        int next = 0;

        for (int i = 0; i < fa; i++) {
            if(current == -1 && i<X[0]) {
                priceSeq[i] = i;
                continue;
            } else if(i == X[0]) {
                current++;
                next++;
            }

            if(i==30) {
                System.out.println("other/test");
            }

            if(next!= X.length && i>=X[current] && i< X[next]) {
                priceSeq[i] = Math.max(0, i-map.get(X[current]));
            } else {
                current++;
                next++;
                i--;
                continue;
            }

            if(next == X.length) {
                priceSeq[i] = Math.max(0, i-map.get(X[current]));
            }
        }

        System.out.println("other/test");

    }
}

package interview.other;

import java.util.HashMap;
import java.util.Scanner;

public class pdd2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int [] seq = new int[N];

        for (int i = 0; i < seq.length; i++) {
            seq[i] = in.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < seq.length; i++) {
            if(map.get(seq[i]) == null) {
                map.put(seq[i], 1);
            } else {
                int count = map.get(seq[i]);
                count++;
                map.put(seq[i], count);
            }
        }

        int max = Integer.MIN_VALUE;

        for (HashMap.Entry<Integer, Integer> entry: map.entrySet()
             ) {
            if(entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        System.out.println(max);
    }
}

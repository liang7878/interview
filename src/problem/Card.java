package problem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Card {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Long> cards = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cards.add(in.nextLong());
        }

        cards.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {

                return o1>o2?-1:1;
            }
        });

        long niu = 0;
        long yang = 0;

        for (int i = 0; i < cards.size(); i++) {
            if(i%2==0) {
                niu += cards.get(i);
            } else {
                yang+=cards.get(i);
            }
        }

        System.out.println(niu-yang);
    }
}

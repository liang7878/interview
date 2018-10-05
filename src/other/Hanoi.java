package other;

import java.util.ArrayList;
import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int k = in.nextInt();

        ArrayList<Integer> tower = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            tower.set(i, in.nextInt());
        }

        for (int i = 0; i < n; i++) {
            if(in.hasNextLine()) {
                int from = in.nextInt();
                int to = in.nextInt();
            }
        }

    }

    public static void move(ArrayList<Integer> tower, int from, int to) {
        int fHeight = tower.get(from);
        int tHeight = tower.get(to);
        fHeight--;
        tHeight++;

        tower.set(from, fHeight);
        tower.set(to, tHeight);
    }
}

package other;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int m = in.nextInt();

        TreeSet<Integer> n1Set = new TreeSet<>();
        TreeSet<Integer> n2Set = new TreeSet<>();

        for (int i = 0; i < n1; i++) {
            n1Set.add(in.nextInt());
        }

        for (int i = 0; i < n2; i++) {
            n2Set.add(in.nextInt());
        }

        System.out.println(getCount(n1Set, n2Set, m));
    }

    public static Integer getCount(TreeSet<Integer> n1Set, TreeSet<Integer> n2Set, int m) {
        int count = 0;

        TreeSet<Integer> n2Sub = (TreeSet<Integer>) n2Set.headSet(m);

        if(n2Sub.size() != 0) {
            Iterator<Integer> iterator = n2Sub.descendingIterator();
            while (iterator.hasNext()) {
                count += getGroupWithOutN2(n1Set, m-iterator.next(), -1);
            }
        }
        count += getGroupWithOutN2(n1Set, m, -1);


        return count;
    }

    public static Integer getGroupWithOutN2(TreeSet<Integer> n1, Integer m , Integer former) {
        if(n1.first() > m) return 0;
        int count = 0;

        if(n1.contains(m) && m<=former) {
            count+=1;
        }

        TreeSet<Integer> sub = (TreeSet<Integer>) n1.headSet(m);

        Iterator<Integer> iterator = sub.descendingIterator();

        while(iterator.hasNext()) {
            Integer tmp = iterator.next();
            count += getGroupWithOutN2(n1, m-tmp, tmp);
        }

        return count;
    }
}

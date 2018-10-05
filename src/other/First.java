package other;

import java.util.*;

public class First {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n0 = in.nextLong();

        ArrayList<Long> arrayList = new ArrayList<>();


        for(int i=0; i< n0; i++) {
            TreeSet<Long> treeSet = new TreeSet<>();
            ArrayList<Long> gaplist = new ArrayList<>();
            long n1 = in.nextLong();
            for(int j=0; j<n1; j++) {
                long last = in.nextLong();
                if(j!=0l) {
                    gaplist.add(last-treeSet.last());
                }
                treeSet.add(last);

            }

            Long maxGap = treeSet.last() - treeSet.first();
            for(int k=0; k<gaplist.size() ; k++) {
                Long gap = getGap(treeSet, gaplist, k);
                if(gap<maxGap) maxGap=gap;
            }
            arrayList.add(maxGap);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    public static Long getGap(TreeSet<Long> tree, ArrayList<Long> list, int gather) {
        Long max = tree.last()-tree.first();
        for(int i=1; i<(tree.size()-1); i++) {
            Long waitGap = 0l;

            for(int j=0; j<list.size(); j++) {
                long sum = list.get((int) j);
                for(int k=j+gather; k<(gather+j); k++) {
                    sum += list.get((int) k);
                }
                if(checkT(tree, sum) && sum<max) {
                    max = sum;
                }
            }

        }

        return max;
    }

    public static boolean checkT(TreeSet<Long> treeSet, Long t) {
        Iterator<Long> iterator = treeSet.iterator();
        Long high = treeSet.last();
        Long low = treeSet.first();
        if(t>(high-low)) {
            return false;
        }

        while(iterator.hasNext()) {
            Long n = iterator.next();
            if(((n+t)<high && !treeSet.contains(n+t)) || ((n-t)>low) && !treeSet.contains(n-t)) {
                return false;
            }
        }

        return true;
    }
}

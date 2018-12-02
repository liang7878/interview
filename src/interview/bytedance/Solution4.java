package interview.bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        List<Long> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            list.add(in.nextLong());
        }

        System.out.println(getCount(list));

        //3 1 2 3
    }

    public static long getCount(List<Long> list) {
        if(list.size() == 0) return 0;
        if(list.size() == 1) return list.get(0);
        if(list.size() == 2) return Math.max(list.get(0), list.get(1)) + list.get(0) * list.get(1);

        long max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if(i==0) {
                long num = list.get(i);
                long xiaochu = num*list.get(i+1);
                list.remove(i);
                max = Math.max(max, xiaochu+ getCount(list));
                list.add(i, num);
            } else if(i==list.size()-1) {
                long num = list.get(i);
                long xiaochu = list.get(i-1)*num;
                list.remove(i);
                max = Math.max(max, xiaochu+ getCount(list));
                list.add(i, num);
            } else {
                long num = list.get(i);
                long xiaochu = list.get(i-1)*num*list.get(i+1);
                list.remove(i);
                max = Math.max(max, xiaochu+ getCount(list));
                list.add(i, num);
            }

        }

        return max;
    }
}

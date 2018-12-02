package interview.wap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String [] tmp = in.nextLine().split(" ");

        int n = Integer.parseInt(tmp[0]); long m = Integer.parseInt(tmp[1]);

        int seg = 0;

        int [] arr = new int[n];

        String [] s = in.nextLine().split(" ");

        arr[0] = Integer.parseInt(s[0]);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            if(arr[i] == list.get(list.size()-1)) continue;
            else list.add(arr[i]);
        }

        for (int i = 0; i < m; i++) {
            String [] temp = in.nextLine().split(" ");
            int flag = Integer.parseInt(temp[0]);

            if(flag == 2) {
                System.out.println(list.size());
            } else if(flag == 1) {
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.add(list.get(0));

                int x = Integer.parseInt(temp[1]), y = Integer.parseInt(temp[2]);

                for (int j = 1; j < list.size(); j++) {
                    if(list.get(j) == x) {
                        if(list1.get(list1.size()-1) == y) continue;
                        list1.add(y);
                    } else {
                        if(list1.get(list1.size()-1) == list.get(j)) continue;
                        list1.add(list.get(j));
                    }
                }
            } else {
                return;
            }
        }

    }


}

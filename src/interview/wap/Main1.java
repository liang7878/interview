package interview.wap;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String [] tmp = in.nextLine().split(" ");

        int n = Integer.parseInt(tmp[0]); long m = Integer.parseInt(tmp[1]);

        int seg = 0;

        int [] arr = new int[n];

        String [] s = in.nextLine().split(" ");

        arr[0] = Integer.parseInt(s[0]);
        seg = 1;

        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            if(arr[i] != arr[i-1]) seg++;
        }

        for (int i = 0; i < m; i++) {
            String [] temp = in.nextLine().split(" ");
            int flag = Integer.parseInt(temp[0]);

            if(flag == 2) {
                System.out.println(seg);
            } else if(flag == 1) {
                if(arr.length == 1){
                    seg = 1;
                } else {
                    int x = Integer.parseInt(temp[1]), y = Integer.parseInt(temp[2]);
                    if (x == y) continue;
                    else seg = paint(arr, Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
                }
            } else {
                return;
            }
        }
    }

    public static int paint(int [] arr, int x, int y) {
        int seg = 1;
        if(arr[0] == x) arr[0] = y;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == x) arr[i] = y;

            if(arr[i] != arr[i-1]) seg++;
        }

        return seg;
    }
}

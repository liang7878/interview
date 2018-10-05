package interview;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(suoxie(in.nextLine()));
        }
        for (int i = 0; i < n; i++) {
            System.out.println(result.get(i));
        }
    }

    public static String suoxie(String a) {
        if(a == null) return null;

        char[] arr = a.toCharArray();
        int[] mark = new int[arr.length+1];
        mark[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]+1) {
                mark[i] = 1+ mark[i-1];
                if(i==arr.length-1) {
                    if(mark[i-1] <= 2 && mark[i] != 3) {
                        for (int j = i-mark[i-1]-1; j <= i; j++) {
                            mark[j] = 0;
                        }
                    } else if(mark[i] == 3) {
                        mark[i]=0;
                    }
                }

            } else {
                if(mark[i-1] <= 2) {
                    for (int j = i-mark[i-1]-1; j <= i; j++) {
                        mark[j] = 0;
                    }
                }
                mark[i-1] = 0;
            }
        }

        int count =0;
        int gang = 0;
        for (int i = 0; i < mark.length; i++) {
            if(mark[i] == 0){
                count++;
                if(i>0 && mark[i] == 0 && mark[i-1] != 0) {
                    gang++;
                }
            }
        }

        count = count+gang-1;

        char[] result = new char[count];
        int step = 0;
        for (int i = 0; i < count; i++) {
            if(mark[i+step] == 0) {
                result[i] = arr[i+step];
            } else {
                if(result[i-1] == '-') {
                    step++;
                    i--;
                    continue;
                } else {
                    result[i] = '-';
//                    step++;
                }
            }
        }

        return new String(result);
    }
}

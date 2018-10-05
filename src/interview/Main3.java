package interview;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        String str = in.nextLine();
        String str = "bbbwww";

        char[] chars = str.toCharArray();

        int length = getYouxu(chars);

        System.out.println(getExLength(chars, length));

//        System.out.println(getExLength(chars, 0, chars.length-1));


//        long bCount = 0l;
//        long wCount = 0l;
//        for (int i = 0; i < chars.length; i++) {
//            if(chars[i] == 'b') {
//                bCount++;
//            } else if(chars[i] == 'w') {
//                wCount++;
//            }
//        }
//
//        long result = bCount>wCount? 2*wCount+1:2*bCount+1;
//
//        System.out.println(result);
    }

    public static int getYouxu(char[] arr) {
        if(arr.length <=1) return arr.length;
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i%2==0) {
                if(arr[i] == arr[0]) {
                    length++;
                } else {
                    break;
                }
            } else {
                if(arr[i] != arr[0]) {
                    length++;
                } else {
                    break;
                }
            }
        }

        return length;
    }

    public static int getExLength(char[] arr, int start) {
        if(arr.length == 0) return 0;
        int maxlength = getYouxu(arr);
        int maxindex = maxlength;
        int reverseBar = maxindex;
        while(start < arr.length) {
            reverse(arr, start);
            if(getYouxu(arr) > maxlength) {
                maxindex =start;
                maxlength = getExLength(arr, getYouxu(arr));
            }
            reverse(arr, start);
            start ++;
        }

        if(start == arr.length) return getYouxu(arr);
        reverse(arr, maxindex);
        return getExLength(arr, getYouxu(arr));

    }

    public static void reverse(char[] arr, int barriar) {
        for (int i = 0; i < barriar/2; i++) {
            char tmp = arr[i];
            arr[i] = arr[barriar-i-1];
            arr[barriar-i-1] = tmp;
        }

        for (int i = 0; i < (arr.length-barriar)/2; i++) {
            char tmp = arr[arr.length-1-i];
            arr[arr.length-1-i] = arr[barriar+i];
            arr[barriar+i] = tmp;
        }
    }
}

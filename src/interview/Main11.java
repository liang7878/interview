package interview;

import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String [] str = in.nextLine().split(" ");

        for (int i = 0; i < str.length; i++) {
            System.out.print(reverse(str[i]));
            if(i!= str.length-1) {
                System.out.print(" ");
            } else {
                System.out.println("");
            }
        }
    }

    public static String reverse(String str) {
        char [] arr = str.toCharArray();

        for (int i = 0; i < arr.length/2; i++) {
            char tmp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = tmp;
        }

        return new String(arr);
    }
}

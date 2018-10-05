package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int [] arr = new int[length];

        int result = 0;

        for (int i = 0; i < length; i++) {
            arr[i] = in.nextInt();
        }
        int childCount = length/3;

        for(int i = 0; i<childCount; i++) {
            result += getCount(arr, i);
        }

        System.out.println(result);
    }

    private static int getCount(int[] arr, int childCount) {
        if(childCount == 1) {
            if(isLegal(arr)) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;




    }

    private static boolean isLegal(int[] childarr) {
        if(childarr.length < 3) return false;
        boolean result = true;

        boolean isDengbi = true;
        boolean isDengcha = true;

        int bi = childarr[1]/childarr[0];
        int cha = childarr[1]-childarr[0];

        for (int i = 0; i < childarr.length-1; i++) {
            if(childarr[i+1]/childarr[i] != bi){
                isDengbi = false;
            }
        }

        for (int i = 0; i < childarr.length-1; i++) {
            if(childarr[i+1]-childarr[i] != cha){
                isDengcha = false;
            }
        }

        return isDengbi||isDengcha;
    }

}

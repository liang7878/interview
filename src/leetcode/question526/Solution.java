package leetcode.question526;

import java.util.ArrayList;

public class Solution {
    static int result = 0;
    public static int countArrangement(int N) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i+1);
        }
        getBeautifulCount(list, 1);
        return result;
    }

    public static void getBeautifulCount(ArrayList<Integer> arr, int n) {
        if(arr.size() == 1) {
            int number = arr.get(0);
            if(number%n == 0 || n%number == 0) {
                result += 1;
                return;
            }
            return;
        }

        ArrayList<Integer> cp = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            cp.add(arr.get(i));
        }

        for (int i = 0; i < cp.size(); i++) {
            int number = cp.get(i);
            if(number%n == 0 || n%number == 0) {
                n++;
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int j = 0; j < cp.size(); j++) {
                    if(j!=i) {
                        tmp.add(arr.get(j));
                    }
                }
                getBeautifulCount(tmp, n);
                n--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countArrangement(3));
    }
}
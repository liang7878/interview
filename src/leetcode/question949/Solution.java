package leetcode.question949;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    int min = -1;
    int MAX = 9+5*60+3*60*60+2*10*60*60;

    public static void main(String[] args){
        Solution solution = new Solution();
        int [] A = {5, 5, 5, 5};
        System.out.println(solution.largestTimeFromDigits(A));
    }

    public String largestTimeFromDigits(int[] A) {

        allSort(A, 0, 3);
        StringBuilder sb = new StringBuilder();
        if(min == -1) {
            return sb.toString();
        }
        sb.append(min%60);
        min = min /60;
        sb.append(min%60);
        min = min /60;
        sb.append(":");
        sb.append(min%10);
        sb.append(min/10);
        return sb.reverse().toString();

    }

    void allSort(int[] array,int begin,int end){
        if(begin==end){
            if(array[2] == 6) {
                return;
            }
            int result = array[0] * 10 *60*60 + array[1]*60*60 + array[2]*60 + array[3];
            if(MAX-result >=0 && MAX-result < MAX-min) {
                min = result;
            }
            return;
        }
        for(int i=begin;i<=end;i++){
            swap(array,begin,i );
            allSort(array, begin+1, end);
            swap(array,begin,i );
        }
    }

    static void swap(int[] array,int a,int b){
        int tem=array[a];
        array[a]=array[b];
        array[b]=tem;
    }
}

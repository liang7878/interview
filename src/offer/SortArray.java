package offer;

import java.util.Collections;
import java.util.ArrayList;
public class SortArray {
    public ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        SortArray sortArray = new SortArray();
        ArrayList<String> rest = sortArray.Permutation("abc");
        System.out.println("other/test");
    }

    public ArrayList<String> Permutation(String str) {
        if(str == null || str.equals("")) {
            return new ArrayList<>();
        }

        char[] arr = str.toCharArray();

        for(int i=0; i<arr.length; i++) {
            swap(arr, 0, i);
            sortString(arr, 0);
            swap(arr, 0, i);;
        }

        Collections.sort(result);

        return result;
    }

    public void sortString(char[] arr, int start) {
        if(start == arr.length - 1) {
            String str = new String(arr);
            if(!result.contains(str)) {
                result.add(new String(arr));
            }
            return;
        }

        for(int i=start+1; i<arr.length; i++) {
            swap(arr, start+1, i);
            sortString(arr, start+1);
            swap(arr, start+1, i);
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
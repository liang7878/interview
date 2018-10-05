package leetcode.question709;

public class Solution {
    public String toLowerCase(String str) {
        char [] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if('A' <= arr[i] && arr[i] <= 'Z') {
                arr[i] = (char) (arr[i] - 'A' + 'a');
            }
        }

        return new String(arr);
    }
}

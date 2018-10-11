package leetcode.question387;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();

    }

    public int firstUniqChar(String s) {
        boolean [] table = new boolean[256];

        char [] a = s.toCharArray();

        int index = -1;

        for (int i = a.length-1; i >= 0 ; i--) {
            if(!table[a[i]]) {
                index = i;
                table[a[i]] = true;
            }
        }

        return index;
    }

//    public int firstUniqChar(String s) {
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        char [] arr = s.toCharArray();
//
//        if(arr.length == 0) return -1;
//
//        for(char c: arr) {
//            map.computeIfAbsent(c, k -> 0);
//
//            map.put(c, map.get(c) + 1);
//        }
//
//        int index = 0;
//
//        for(char c: arr) {
//            if(map.get(c) == 1) return index;
//            index++;
//        }
//        return 0;
//    }
}

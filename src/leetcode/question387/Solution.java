package leetcode.question387;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();

    }

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        char [] arr = s.toCharArray();

        if(arr.length == 0) return -1;

        for(char c: arr) {
            map.computeIfAbsent(c, k -> 0);

            map.put(c, map.get(c) + 1);
        }

        int index = 0;

        for(char c: arr) {
            if(map.get(c) == 1) return index;
            index++;
        }
        return 0;
    }
}

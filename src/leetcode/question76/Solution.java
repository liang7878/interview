package leetcode.question76;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        int SIZE = t.length();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char c: t.toCharArray()) {
            tMap.computeIfAbsent(c, k->0);
            tMap.put(c, tMap.get(c)+1);
        }

        char [] arr = s.toCharArray();

        int left = 0;

        int cnt = 0;

        int minlen = Integer.MAX_VALUE;

        String res = "";

        for (int i = 0; i < arr.length; i++) {
            if(tMap.containsKey(arr[i])){
                tMap.put(arr[i], tMap.get(arr[i])-1);
                if(tMap.get(arr[i]) >= 0) cnt++;

                while(cnt == t.length()) {
                    if(minlen > i-left+1) {
                        minlen = i-left+1;
                        res = s.substring(left, left+minlen);
                    }
                    if(tMap.containsKey(arr[left])) {
                        tMap.put(arr[left], tMap.get(arr[left])+1);
                        if(tMap.get(arr[left]) >0) cnt--;
                    }
                    left++;
                }
            }
        }

        return res;

    }
}

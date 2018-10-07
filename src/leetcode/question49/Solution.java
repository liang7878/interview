package leetcode.question49;

import java.util.*;

public class Solution {



    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String str: strs) {
            char [] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            map.computeIfAbsent(key, k->new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

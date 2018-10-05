package leetcode.question347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();


    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> [] list = new List[nums.length+1];

        for (Integer key: map.keySet()) {
            if(list[map.get(key)] == null) list[map.get(key)] = new ArrayList<>();

            list[map.get(key)].add(key);
        }

        for (int pos = list.length; pos >=0 ; pos--) {
            if(list[pos] == null) continue;

            for(int num: list[pos]){
                if(k!=0) {
                    result.add(num);
                    k--;
                }
            }
        }

        return result;
    }
}

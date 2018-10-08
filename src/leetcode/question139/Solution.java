package leetcode.question139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        ArrayList<String> test = new ArrayList<>();
        test.add("leet");
        test.add("code");

        System.out.println(solution.wordBreak("leetcode", test));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < wordDict.size(); i++) {
            set.addAll(wordDict);
        }

        boolean [] mark = new boolean[s.length() + 1];

        mark[0] = true;

        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 0; j < i; j++) {
                String test= s.substring(j, i);

                if(mark[j] && set.contains(s.substring(j, i))) {
                    mark[i] = true;
                    break;
                }
            }
        }

        return mark[s.length()];
    }
}

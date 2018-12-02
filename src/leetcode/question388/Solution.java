package leetcode.question388;

import java.util.*;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.lengthLongestPath("a\n\tb.txt\na2\n\tb2.txt"));
    }


    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int maxlength =0;

        for(String s: input.split("\n")) {
            int lev = s.lastIndexOf("\t") + 1;
            while(lev+1<stack.size()) stack.pop();
            int len = stack.peek() + s.length() - lev + 1;
            stack.push(len);
            if(s.contains(".")) maxlength = Math.max(maxlength, len-1);
        }

        return maxlength;
    }
}

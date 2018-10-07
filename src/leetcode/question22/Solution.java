package leetcode.question22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();

        List<String> test = solution.generateParenthesis(3);

        System.out.println("test");
    }


    static List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;

        addStr(new StringBuilder(), left, right);

        return result;
    }

    private void addStr(StringBuilder current, int left, int right) {
        if(left > right) return;

        if(left == 0 && right == 0) {
            if(!result.contains(current)) result.add(current.toString());
        }

        if(left < right) {
            if(left > 0)  addStr(new StringBuilder(current).append("("), left-1, right);
            if(right > 0) addStr(new StringBuilder(current).append(")"), left, right-1);
        } else if(left == right){
            if(left > 0)  addStr(new StringBuilder(current).append("("), left-1, right);
        }
    }
}

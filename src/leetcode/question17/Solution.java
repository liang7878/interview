package leetcode.question17;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations("23");
        System.out.println("test");
    }


    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        StringBuilder sb = new StringBuilder(digits);

        helper(new StringBuilder(), sb, 0);

        return result;
    }

    private void helper(StringBuilder current, StringBuilder digits, int index) {
        if(index == digits.length()) {
            result.add(current.toString());
            return;
        }

        switch (digits.charAt(index)) {
            case '2':
                helper(new StringBuilder(current).append('a'), digits, index+1);
                helper(new StringBuilder(current).append('b'), digits, index+1);
                helper(new StringBuilder(current).append('c'), digits, index+1);
                break;
            case '3':
                helper(new StringBuilder(current).append('d'), digits, index+1);
                helper(new StringBuilder(current).append('e'), digits, index+1);
                helper(new StringBuilder(current).append('f'), digits, index+1);
                break;
            case '4':
                helper(new StringBuilder(current).append('g'), digits, index+1);
                helper(new StringBuilder(current).append('h'), digits, index+1);
                helper(new StringBuilder(current).append('i'), digits, index+1);
                break;
            case '5':
                helper(new StringBuilder(current).append('j'), digits, index+1);
                helper(new StringBuilder(current).append('k'), digits, index+1);
                helper(new StringBuilder(current).append('l'), digits, index+1);
                break;
            case '6':
                helper(new StringBuilder(current).append('m'), digits, index+1);
                helper(new StringBuilder(current).append('n'), digits, index+1);
                helper(new StringBuilder(current).append('o'), digits, index+1);
                break;
            case '7':
                helper(new StringBuilder(current).append('p'), digits, index+1);
                helper(new StringBuilder(current).append('q'), digits, index+1);
                helper(new StringBuilder(current).append('r'), digits, index+1);
                helper(new StringBuilder(current).append('s'), digits, index+1);
                break;
            case '8':
                helper(new StringBuilder(current).append('t'), digits, index+1);
                helper(new StringBuilder(current).append('u'), digits, index+1);
                helper(new StringBuilder(current).append('v'), digits, index+1);
                break;
            case '9':
                helper(new StringBuilder(current).append('w'), digits, index+1);
                helper(new StringBuilder(current).append('x'), digits, index+1);
                helper(new StringBuilder(current).append('y'), digits, index+1);
                helper(new StringBuilder(current).append('z'), digits, index+1);
                break;
            default:
                break;
        }
    }
}

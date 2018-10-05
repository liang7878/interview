package leetcode.question804;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println();
    }

    public int uniqueMorseRepresentations(String[] words) {
        String [] MORS = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> set = new HashSet<>();

        for(String word: words) {
            char [] a = word.toCharArray();

            StringBuilder sb = new StringBuilder();

            for(char c: a) {
                sb.append(MORS[c-'a']);
            }

            set.add(sb.toString());
        }

        return set.size();
    }
}

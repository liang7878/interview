package leetcode.question443;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        String test = "abbbbbbbbbbbbbbbbbbbbbbbbbssssssssssssssssssssssbsbsssssssssssssssss";
        String test = "abbbbbbbbbbcg";

        System.out.println(solution.compress(test.toCharArray()));
    }

    public int compress(char[] chars) {
        int index = 0, indexAns = 0;
        while(index<chars.length) {
            char current = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == current) {
                index++;
                count++;
            }

            chars[indexAns++] = current;

            if(count!=1) {
                for(char b: Integer.toString(count).toCharArray()) {
                    chars[indexAns++] = b;
                }
            }
        }

        return indexAns;
    }
}

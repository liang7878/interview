package leetcode.question66;

import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();

        int [] test = new int[]{1,9,1};

        int [] result = solution.plusOne(test);

        System.out.println("test");
    }

    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < digits.length; i++) {
            stack.push(digits[i]);
        }

        if(stack.peek() == 9) {
            int length = 0;
            while(stack.size() != 0 && stack.peek()==9) {
                stack.pop();
                length++;
            }

            if(stack.size() != 0) {
                stack.push(stack.pop() + 1);
            } else {
                stack.push(1);
            }

            while (length != 0) {
                stack.push(0);
                length--;
            }

        } else {
            stack.push(stack.pop() + 1);
        }

        int [] result = new int[stack.size()];

        for (int i = result.length-1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}

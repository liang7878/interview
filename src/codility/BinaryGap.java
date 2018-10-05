package codility;

import java.util.Scanner;
import java.util.Stack;

public class BinaryGap {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int input = in.nextInt();

        System.out.println(solution(input));
    }

    public static int solution(int N) {
        int result = 0;
        char[] Nchar = Integer.toBinaryString(N).toCharArray();

        int maxGap = 0;

        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < Nchar.length; i++) {
            if(Nchar[i]=='1') {
                if(stack.empty()) {
                    stack.push('1');
                } else {
                    while (stack.peek() == '0') {
                        stack.pop();
                    }
                    result = Math.max(result, count);
                    count = 0;
                }
            } else {
                stack.push(Nchar[i]);
                count++;
            }
        }
        return result;
    }
}

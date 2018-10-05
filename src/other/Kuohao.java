package other;

import java.util.Scanner;
import java.util.Stack;

public class Kuohao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        char[] arr = str.toCharArray();

        if(arr.length == 0) {
            System.out.println(0);
        }

        Stack<Character> stack = new Stack<>();

        int depth = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '(') {
                stack.push('(');
                depth = Math.max(depth, count+stack.size()-1);
                count = 0;
            } else {
                stack.pop();
                count++;
            }
        }

        depth = Math.max(depth, count);

        System.out.println(depth);

    }
}

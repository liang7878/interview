package interview.bytedance;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Solution1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        //abcdiiiioo

        Deque<Character> deque = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        String input = in.nextLine();
//        String input = "zijietiaodong";

        char [] arr = input.toCharArray();

        boolean [] flag = new boolean[arr.length];

        int index = 0;

        boolean previous = false; //true 输入，false 删除



        for(int i=0; i<arr.length; i++) {
            char c = arr[i];
            if(deque.isEmpty() && i==0) {
                if(c == 'i') continue;
                if(c == 'o') continue;
                deque.push(c);
                previous = true;
            } else {
                if(c == 'i') {
                    if(deque.isEmpty()) continue;
                    stack.push(deque.pop());
                    previous = false;
                    continue;
                }
                if(c == 'o') {
                    if(i-1>=0 && arr[i-1] == 'i') {
                        if(!stack.isEmpty()){
                            deque.push(stack.pop());
                            previous = true;
                        }
                    } else {
                        if(previous) {
                            if(!deque.isEmpty()) {
                                stack.push(deque.pop());
                            }
                        } else {
                            deque.push(stack.pop());
                        }

                    }
                    continue;
                }

                deque.push(c);
            }
        }

        int length = deque.size();

        for (int i = 0; i < length; i++) {
            System.out.print(deque.pollLast());
        }


    }
}

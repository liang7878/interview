package other.nvida;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int[] exchange(int[] list) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < list.length; i++) {
            if(!stack.isEmpty()) {
                int next =list[i];
                while(!stack.isEmpty() && stack.peek() == next) {
                    stack.pop();
                    next = next*2;
                }
                stack.push(next);
            } else {
                stack.push(list[i]);
            }
        }

        int [] result = new int[stack.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }

        Arrays.sort(result);

        return result;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int[] res;
//
//        int _list_size = 0;
//        _list_size = Integer.parseInt(in.nextLine().trim());
//        int[] _list = new int[_list_size];
//        int _list_item;
//        for(int _list_i = 0; _list_i < _list_size; _list_i++) {
//            _list_item = Integer.parseInt(in.nextLine().trim());
//            _list[_list_i] = _list_item;
//        }



        int [] _list = new int[]{2,2,16,4,4,2,2,4,4};

        int [] res = exchange(_list);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}

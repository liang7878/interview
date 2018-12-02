package interview.bytedance;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());

        for (int i = 0; i < num; i++) {
            String s = in.nextLine();
            char [] arr = s.toCharArray();

            StringBuilder res = new StringBuilder();

            boolean previous = false;

            for (int j = 0; j < arr.length; j++) {
                char c = arr[j];

                if(j == 0 && (c>='A' && c<='Z')) {
                    res.append((char)(c-'A'+'a'));
                    previous = true;
                } else if(j<arr.length-1 && previous == true) {
                    if(c>='a' && c<= 'z') {
                        res.append(c);
                        previous = false;
                    } else if(c>='A' && c <='Z') {
                        char next = arr[j+1];
                        //如果后面还是大写，就直接append这个字母的小写
                        if(next >= 'A' && next<='Z') {
                            res.append((char)(c-'A'+'a'));
                        } else {
                            res.append("_");
                            res.append((char)(c-'A'+'a'));
                        }
                        //如果后面是小写，就加一个下划线然后再变小写
                    } else {
                        res.append(c);
                        previous =false;
                    }
                } else if(j<arr.length-1 && previous == false) {
                    if(c>='a' && c<= 'z') {
                        res.append(c);
                        previous = false;
                    } else if(c>='A' && c <='Z') {
                        previous = true;
                        //如果后面还是大写，就直接append这个字母的小写
                        res.append("_");
                        res.append((char)(c-'A'+'a'));

                        //如果后面是小写，就加一个下划线然后再变小写
                    } else {
                        res.append(c);
                        previous =false;
                    }
                } else if(j==arr.length-1){
                    if(c>='A' && c <='Z') {
                        if(previous) {
                            res.append((char)(c-'A'+'a'));
                        } else {
                            res.append("_");
                            res.append((char)(c-'A'+'a'));
                        }
                    } else {
                        res.append(c);
                    }
                }
            }

            System.out.println(res.toString());

        }

    }
}

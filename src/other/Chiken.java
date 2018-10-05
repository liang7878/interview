package other;

import java.util.Scanner;

public class Chiken {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        char[] strlist = str.toCharArray();
        int c=0;
        int d=0;

        for(int i=0; i<strlist.length; i++) {
            if(strlist[i]=='C') {
                c++;
            } else if(strlist[i]=='D') {
                d++;
            }
        }

        char[] back = strlist.clone();

        int former = 0;
        int tailer = 0;
        char formChar;
        char tailChar;

        if(c>d) {
            former = c;
            tailer = d;
            formChar = 'C';
            tailer = 'D';
        } else {
            former = d;
            tailer = c;
            formChar = 'D';
            tailChar = 'C';
        }

        int count1 = 0;

        boolean flag = false;
        int left =0;

        while(!flag) {
            for (; left < strlist.length; left++) {
                if(left<former && strlist[left] != formChar){
                    flag = false;
                    char tmp = strlist[left];
                    strlist[left] = strlist[left+1];
                    strlist[left+1] = tmp;
                    count1++;
                }
            }

            flag = true;
            for (int i = 0; i < former; i++) {
                if(strlist[i] != formChar) {
                    flag = false;
                    break;
                }
            }
        }

//        System.out.println(count1);


        strlist = back.clone();

        former = 0;
        tailer = 0;

        if(c>d) {
            former = d;
            tailer = c;
            formChar = 'D';
            tailer = 'C';
        } else {
            former = c;
            tailer = d;
            formChar = 'C';
            tailChar = 'D';
        }

        int count2 = 0;

        flag = false;
        left =0;

        while(!flag) {
            for (; left < strlist.length; left++) {
                if(left<former && strlist[left] != formChar){
                    flag = false;
                    char tmp = strlist[left];
                    strlist[left] = strlist[left+1];
                    strlist[left+1] = tmp;
                    count2++;
                }
            }

            flag = true;
            for (int i = 0; i < former; i++) {
                if(strlist[i] != formChar) {
                    flag = false;
                    break;
                }
            }
        }

        if(count1<count2) {
            System.out.println(count1);
        }else {
            System.out.println(count2);
        }
    }
}

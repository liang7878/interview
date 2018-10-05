package codility;

public class Solution {
    public static void main(String[] args) {
        LeftRotateString("abcdefg", 2);
    }

    public static String LeftRotateString(String str,int n) {


        char [] chars = str.toCharArray();

        n = n%chars.length;
        reverse(chars, 0, n-1);
        reverse(chars, n, chars.length-1);
        reverse(chars, 0, chars.length-1);
        return new String(chars);
    }

    public static char[] reverse(char[] str, int start, int end) {
        int i=start;
        int j=end;
        while(i<j) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
        return str;
    }
}

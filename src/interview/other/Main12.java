package interview.other;

import java.util.Scanner;

public class Main12 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        String result = multiBigInt(a, b);

        char[] tmp = result.toCharArray();
        int i = 0;
        for (; i < tmp.length; i++) {
            if (tmp[i] == '0')
                continue;
            else
                break;
        }
        System.out.println(result.substring(i, result.length()));

    }
    public static String multiBigIntSingle(char[] a, char b) {
        int pre = 0;
        String result = "";
        for (int j = a.length - 1; j >= 0; j--) {
            int tmp = a[j] - '0';
            int tmpb = b - '0';
            int sum = tmp * tmpb + pre;
            pre = sum / 10;
            int left = sum % 10;
            result += left;
        }
        if (pre != 0)
            result += pre;

        char[] sb = result.toCharArray();
        String value = "";
        for (int j = sb.length - 1; j >= 0; j--)
            value += sb[j];
        return value;
    }
    public static String multiBigInt(String a, String b) {
        if (a.length() == 1)
            return multiBigIntSingle(b.toCharArray(), a.charAt(0));
        if (b.length() == 1)
            return multiBigIntSingle(a.toCharArray(), b.charAt(0));

        int mid1 = a.length() / 2;
        int mid2 = b.length() / 2;

        String A = a.substring(0, mid1);
        String B = a.substring(mid1, a.length());

        String C = b.substring(0, mid2);
        String D = b.substring(mid2, b.length());

        String AC = multiBigInt(A, C);
        for (int i = 0; i < a.length() - mid1 + b.length() - mid2; i++) {
            AC += '0';
        }

        String AD = multiBigInt(A, D);
        for (int i = 0; i < a.length() - mid1; i++) {
            AD += '0';
        }

        String CB = multiBigInt(C, B);
        for (int i = 0; i < b.length() - mid2; i++) {
            CB += '0';
        }

        String BD = multiBigInt(B, D);

        String result = addBigInt(AC.toCharArray(), CB.toCharArray(), 0);
        result = addBigInt(result.toCharArray(), AD.toCharArray(), 0);
        result = addBigInt(result.toCharArray(), BD.toCharArray(), 0);

        return result;
    }
    
    public static String addBigInt(char[] a, char[] b, int len) {
        int maxlen = a.length + b.length;
        char[] revA = reverse(a);
        char[] revB = reverse(b);
        String sb = "";
        int tmpa = 0;
        int tmpb = 0;
        int pre = 0;
        for (int i = 0; i < maxlen; i++) {
            tmpa = 0;
            tmpb = 0;
            if (i < revA.length)
                tmpa = revA[i] - '0';
            
            if (i < revB.length + len && i >= len)
                tmpb = revB[i - len] - '0';

            int sum = tmpa + tmpb + pre;
            pre = sum / 10;

            int left = sum % 10;
            sb += left;
        }
        while (pre != 0) {
            sb += pre % 10;
            pre /= 10;
        }
        char[] result = sb.toCharArray();
        String value = "";
        for (int j = result.length - 1; j >= 0; j--)
            value += result[j];
        return value;
    }

    public static char[] reverse(char[] arr) {

        for (int i = 0; i < arr.length/2; i++) {
            char tmp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = tmp;
        }

        return arr;
    }

}

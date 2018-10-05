package other;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Count {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long a = in.nextLong();
        Long b = in.nextLong();
        Long c = in.nextLong();
        Double result = Math.pow(2, a)+Math.pow(2, b)-Math.pow(2,c);
        System.out.println(appearNumber(Long.toBinaryString(result.longValue()), "1"));
    }

//    public static int appearNumber(String srcText, String findText) {
//        int count = 0;
//        int index = 0;
//        while ((index = srcText.indexOf(findText, index)) != -1) {
//            index = index + findText.length();
//            count++;
//        }
//        return count;
//    }

    public static int appearNumber(String srcText, String findText) {
        int count = 0;
        Pattern p = Pattern.compile(findText);
        Matcher m = p.matcher(srcText);
        while (m.find()) {
            count++;
        }
        return count;
    }
}

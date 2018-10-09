package interview.bytedance;


import java.util.*;

public class Question3 {
    public static void main(String[] args) {
        Map<Character, String> map = new HashMap<>();
        map.put('0', "");
        map.put('1', "-");
        map.put('2', "+");
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        for (int index = 0; index < N; index++) {
            String exam = in.nextLine();

            int count =0;

            String str = null;
            StringBuilder expressions = null;

            int Range = (int) Math.pow(new Double(exam.length()), 3);

            for (int i = 0; i < Range; i++) {
                StringBuilder zero = new StringBuilder();
                for (int j = 0; j < exam.length()-1; j++) {
                    zero.append("0");
                }

                // 将数字转换为8位3进制
                str = zero.toString() + radixConvert(i, 3);
                str = str.substring(str.length() - exam.length());
                // 算术表达式以1开头
                expressions = new StringBuilder();
                for (int j = 0; j < exam.length(); j++) {
                    expressions.append(map.get(str.charAt(j))).append(exam.charAt(j));
                }
                // 得到运算结果
                long result = simpleEval(expressions.toString());
                if (result == 0 && expressions.charAt(0) != '+') {
                    count++;
                }
            }

            System.out.println(count);
        }

    }

    /**
     * 运算简单的加减算数表达式
     *
     * @param expressions
     *            算数表达式
     * @return
     */
    public static long simpleEval(String expressions) {
        int tempIndex = 0;
        List<Long> numberList = new ArrayList<>(); // 数字列表
        List<Character> operatorList = new ArrayList<>(); // 运算符列表
        for (int i = 0; i < expressions.length(); i++) {
            if ((expressions.charAt(i) == '+' || expressions.charAt(i) == '-') && i!=0) {
                try {
                    numberList.add(Long.parseLong(expressions.substring(tempIndex, i)));
                } catch (Exception e) {
                    System.out.println(e.toString());
                }

                operatorList.add(expressions.charAt(i));
                tempIndex = i + 1;
            } else if((expressions.charAt(i) == '+' || expressions.charAt(i) == '-') && i==0){
                numberList.add(0l);
                operatorList.add(expressions.charAt(i));
                tempIndex = i + 1;
            }
        }
        // 当表达式里没有运算符，即表达式为一个数字，直接输出
        if (operatorList.size() == 0) {
            return Long.parseLong(expressions);
        }
        // 把最后一个运算符后的数字加入数字列表
        if (tempIndex < expressions.length()) {
            numberList.add(Long.parseLong(expressions.substring(tempIndex, expressions.length())));
        }
        // 计算结果
        long result = numberList.get(0);
        for (int i = 0; i < operatorList.size(); i++) {
            if (operatorList.get(i) == '+') {
                result = result + numberList.get(i + 1);
            } else if (operatorList.get(i) == '-') {
                result = result - numberList.get(i + 1);
            }
        }
        return result;
    }

    /**
     * 实现将十进制数num转换成radix进制数
     *
     * @param num
     *            十进制数
     * @param radix
     *            进制
     * @return 转换后的数
     */
    public static String radixConvert(int num, int radix) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false; // 正负标记
        if (num == 0) {
            return "0";
        } else if (num < 0) {
            num = num * -1;
            flag = true;
        }
        while (num > 0) {
            int m = num % radix;
            num = num / radix;
            sb.append(m);
        }
        if (flag) {
            sb.append("-");
        }
        // 倒叙输出字符串
        return sb.reverse().toString();
    }
}
 

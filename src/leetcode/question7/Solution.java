package leetcode.question7;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();

        System.out.println(solution.reverse(123));
    }

    public int reverse(int x) {
        int result = 0;

        while(x != 0) {
            int tail = x%10;

            int newResult = result*10+tail;

            if((newResult-tail)/10 != result) {
                return 0;
            }
            result = newResult;

            x = x/10;
        }

        return result;
    }

//    public int reverse(int x) {
//        if(x == 0) return x;
//
//        int result;
//        boolean iszheng = true;
//        if(x < 0) {
//            iszheng = false;
//            x = -x;
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        while(x/10 != 0) {
//            sb.append(x%10);
//            x = x/10;
//        }
//
//        sb.append(x);
//
//        if(!iszheng) x=-x;
//
//        return x;
//    }
}

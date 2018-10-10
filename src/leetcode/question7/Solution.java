package leetcode.question7;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();

        System.out.println(solution.reverse(123));
    }

    public int reverse(int x) {
        if(x == 0) return x;

        int result;
        boolean iszheng = true;
        if(x < 0) {
            iszheng = false;
            x = -x;
        }

        StringBuilder sb = new StringBuilder();

        while(x/10 != 0) {
            sb.append(x%10);
            x = x/10;
        }

        sb.append(x);

        if(!iszheng) x=-x;

        return x;
    }
}

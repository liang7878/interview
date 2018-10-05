package leetcode.question657;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();

        System.out.println(solution.judgeCircle("LL"));
    }

    public boolean judgeCircle(String moves) {
        char [] arr = moves.toCharArray();
        int shui = 0, chui = 0;

        for (char c : arr) {
            switch (c) {
                case 'L':
                    shui--;
                    break;
                case 'R':
                    shui++;
                    break;
                case 'U':
                    chui++;
                    break;
                case 'D':
                    chui--;
                    break;
            }
        }

        if(shui == 0 && chui == 0) return true;

        return false;
    }
}

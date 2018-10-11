package leetcode.question125;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();

        int start = 0;
        int end = str.length()-1;

        while (start <= end) {
            char a= str.charAt(start);
            char b = str.charAt(end);
            if(!Character.isLetterOrDigit(a)) {
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(b)) {
                end--;
                continue;
            }

            if(a != b) return false;

            start++;
            end--;
        }

        return true;
    }
}

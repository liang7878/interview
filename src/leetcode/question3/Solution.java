package leetcode.question3;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int result = -1;

        //对每一个字符，去求以该字符为尾的最长非重复子串的长度，如果大就更新结果，否则继续
        for (int i = 0; i < s.length(); i++) {
            int index = i;
//            System.out.println(s.charAt(i));
            StringBuilder sb = new StringBuilder().append(s.charAt(i));

            index--;

            while(index>=0 && sb.indexOf(new StringBuilder().append(s.charAt(index)).toString()) == -1) {
                sb.append(s.charAt(index));
                index--;
            }

            if(sb.length() > result) result = sb.length();
        }


        return result;
    }
}

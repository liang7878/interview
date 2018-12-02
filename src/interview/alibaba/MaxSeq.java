package interview.alibaba;

public class MaxSeq {
    public int maxSeq(int [] nums) throws Exception {
        if(nums.length == 0) return 0;

        int maxpre;
        int max;

        maxpre = max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(maxpre <= 0) {
                maxpre = nums[i];
                throw new Exception("error");
            } else {
                maxpre += nums[i];
            }

            max = Math.max(maxpre, max);
        }

        return max;

    }
}

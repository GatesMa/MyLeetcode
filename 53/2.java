class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length, ma_x = nums[0];
        for(int i = 1;i < len;i++) {
            if(nums[i - 1] > 0) nums[i] += nums[i - 1];
            ma_x = Math.max(ma_x, nums[i]);
        }
        return ma_x;
    }
}

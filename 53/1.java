class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int currSum = nums[0], ma_x = nums[0];
        for(int i = 1;i < nums.length;i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            ma_x = Math.max(ma_x, currSum);
        }
        return ma_x;
    }
}

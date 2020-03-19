class Solution {
    public int maxProduct(int[] nums) {
        int ma_x = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);
            ma_x = Math.max(ma_x, imax);
        }
        return ma_x;
    }
}

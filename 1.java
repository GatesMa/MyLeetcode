class Solution {
    public int rob(int[] nums) {
        int pre = 0, cur = 0;
        for(int  i = 0;i < nums.length;i++) {
            int temp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = temp;
        }
        return cur;
    }
}

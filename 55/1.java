class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums == null) return false;
        return canJumpHelper(nums, 0); 
    }

    public boolean canJumpHelper(int[] nums, int nowIndex) {
        if(nowIndex == nums.length - 1) {
            return true;
        }
        int furtherestIndex = Math.min(nums[nowIndex] + nowIndex, nums.length - 1);
        for(int i = nowIndex + 1;i <= furtherestIndex;i++) {
            if(canJumpHelper(nums, i)) {
                return true;
            }
        }
        return false;
    }


}
//. 超时

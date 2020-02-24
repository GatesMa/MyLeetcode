enum Index {
    GOOD, BAD, UNKNOWN
}


class Solution {
    Index[] memo;

    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums == null) return false;
        memo = new Index[nums.length];
        for(int i = 0;i < nums.length;i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[nums.length - 1] = Index.GOOD;
        return canJumpHelper(nums, 0); 
    }

    public boolean canJumpHelper(int[] nums, int nowIndex) {
        if(memo[nowIndex] != Index.UNKNOWN) {
            return memo[nowIndex] == Index.GOOD ? true : false;
        }
        int furtherestIndex = Math.min(nums[nowIndex] + nowIndex, nums.length - 1);
        for(int i = nowIndex + 1;i <= furtherestIndex;i++) {
            if(canJumpHelper(nums, i)) {
                memo[nowIndex] = Index.GOOD;
                return true;
            }
        }
        memo[nowIndex] = Index.BAD;
        return false;
    }
}

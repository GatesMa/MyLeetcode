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

        for(int i = nums.length - 2;i >= 0;i--) {
            int furtherestIndex = Math.min(nums[i] + i, nums.length - 1);
            for(int j = i + 1;j <= furtherestIndex;j++) {
                if(memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD; 
    }
}

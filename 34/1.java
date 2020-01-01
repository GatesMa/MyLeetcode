class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int left, right;
        int L = 0, R = nums.length - 1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(nums[mid] == target) {
                int i = mid, j = mid;
                while(i >= 0 && nums[i] == target) i--;
                while(j <= nums.length - 1 && nums[j] == target) j++;
                return new int[]{i + 1, j - 1};
            } else {
                if(nums[mid] > target) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}

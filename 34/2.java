class Solution {

    public int binarySearch(int[] nums, double target) {
        int L = 0, R = nums.length - 1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(nums[mid] < target) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return L;
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = binarySearch(nums, target - 0.5);
        int right = binarySearch(nums, target + 0.5); 
        if(left == right) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right - 1};
    }
}

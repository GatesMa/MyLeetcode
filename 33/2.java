class Solution {

    public int find_rotation_index(int[] nums) {
        int L = 0, R = nums.length - 1;
        if(nums[L] < nums[R]) return 0;
        
        while(L <= R) {
            int mid = (L + R) / 2;
            if(nums[mid] > nums[mid + 1]) return mid + 1;
            else {
                if(nums[mid] >= nums[L]) {//注意mid和left的值相等的情况，left应该左移
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
        }
        return 0;
    }
    public int search_from_seg(int[] nums, int target, int left, int right) {
        int L = left, R = right;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(nums[mid] == target) return mid;
            else {
                if(nums[mid] < target) L = mid + 1;
                else R = mid - 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int index = find_rotation_index(nums);
        if(index == 0) {
            return search_from_seg(nums, target, 0, nums.length - 1);
        }
        if(target < nums[0]) {
            return search_from_seg(nums, target, index, nums.length - 1);
        } else {
            return search_from_seg(nums, target, 0, index);
        }
    }

}

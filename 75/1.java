class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, p1 = nums.length - 1, curr = 0;
        while(curr <= p1) {
            if(nums[curr] == 0) {
                swap(nums, curr, p0);
                p0++;
                curr++;
            } else if(nums[curr] == 1) {
                curr++;
            } else {
                swap(nums, curr, p1);
                p1--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class Solution {
    public int maxArea(int[] height) {
        int ma_x = -1;
        int l = 0, r = height.length - 1;
        while(l < r) {
            ma_x = Math.max(ma_x, (r - l) * Math.min(height[r], height[l]));
            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ma_x;
    }
}

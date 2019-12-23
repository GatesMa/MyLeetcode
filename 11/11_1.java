class Solution {
    public int maxArea(int[] height) {
        int ma_x = -1;
        for(int i = 0;i < height.length - 1;i++) {
            for(int j = i + 1;j < height.length;j++) {
                int x = j - i;
                int y = Math.min(height[j], height[i]);
                ma_x = Math.max(ma_x, x * y);
            }
        }
        return ma_x;
    }
}

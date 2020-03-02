class Solution {
    public int maxProfit(int[] prices) {
        int fit = 0;
        for(int i = 0;i < prices.length;i++) {
            for(int j = i + 1;j < prices.length;j++) {
                fit = Math.max(fit, prices[j] - prices[i]);
            }
        }
        return fit;
    }
}

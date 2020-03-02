class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0; 
        int fit = 0;
        int minPrice = prices[0];
        for(int i = 1;i < prices.length;i++) {
            fit = Math.max(fit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return fit;
    }
}

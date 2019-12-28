class Solution {
    public int longestValidParentheses(String s) {
        int ma_x = 0;
        int[] dp = new int[s.length()];
        for(int i = 1;i < s.length();i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i - 1) == '(') {
                    dp[i] = ((i > 1) ? dp[i - 2]: 0) + 2;
                } else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1] > 1) ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                ma_x = Math.max(ma_x, dp[i]);
            }
        }
        return ma_x;
    }
}

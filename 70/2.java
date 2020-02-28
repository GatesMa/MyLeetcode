class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        int[] num = new int[n + 1];
        num[1] = 1;
        num[2] = 2;
        for(int i = 3;i <= n;i ++) {
            num[i] = num[i - 1] + num[i - 2];
        }
        return num[n];
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        int ma_x = 0;
        int len = s.length();
        for(int i = 0;i < len;i++) {
            for(int j = i + 2;j <= len;j+=2) {
                if(isValid(s.substring(i, j))) {
                    ma_x = Math.max(ma_x, j - i);
                }
            }
        }
        return ma_x;
    }

    public boolean isValid(String s) {
        int left = 0;
        int len = s.length();
        for(int i = 0;i < len;i++) {
            if(s.charAt(i) == '(') {
                left++;
            } else {
                if(left == 0) return false;
                left--;
            }
        }
        if(left != 0) return false;
        return true;
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        int ma_x = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.empty()) {
                    stack.push(i);
                } else {
                    ma_x = Math.max(ma_x, i - stack.peek());
                }
            }
        }
        return ma_x;
    }
}

class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length()==0) return true;
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i = 0;i < len;i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if(stack.empty()) return false;
                char ch = stack.peek();
                stack.pop();
                if(ch == '(' && s.charAt(i) != ')' || ch == '{' && s.charAt(i) != '}' || ch == '[' && s.charAt(i) != ']') {
                    return false;
                }
            }
        }
        if(!stack.empty()) {
            return false;
        }
        return true;
    }
}

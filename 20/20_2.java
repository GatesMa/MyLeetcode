class Solution {

    private HashMap<Character, Character> mappings = new HashMap(){{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};
    
    public boolean isValid(String s) {
        if(s == null || s.length()==0) return true;
        if(s.length()% 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i = 0;i < len;i++) {
            char ch = s.charAt(i);
            if(mappings.containsKey(ch)) {
                if(stack.empty()) return false;
                char frontCh = stack.pop();
                if(frontCh != mappings.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        if(!stack.empty()) {
            return false;
        }
        return true;
    }
}

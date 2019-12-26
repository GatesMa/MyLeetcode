
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String str,int left, int right, int max) {
        if(str.length() == 2 * max) {
            ans.add(str);
            return;
        }
        if(left < max) {
            backtrack(ans, str+"(", left + 1, right, max);
        }
        if(right < left) {
            backtrack(ans, str+")", left, right + 1, max);
        }
    }
}

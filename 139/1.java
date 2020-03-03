class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<String>(wordDict), 0, new Boolean[s.length()]);
    }

    public boolean wordBreak(String s,Set<String> set, int start, Boolean[] memo) {
        if(start == s.length()) return true;
        if(memo[start] != null) return memo[start];
        for(int i = start + 1;i <= s.length();i++) {
            if(set.contains(s.substring(start, i)) && wordBreak(s, set, i, memo)) {
                memo[start] = true;
                return memo[start];
            }
        }
        memo[start] = false;
        return memo[start];
    }
}

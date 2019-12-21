class Solution {
    public int lengthOfLongestSubstring(String s) {
        int index[] = new int[128];
        int res = 0;
        int len =  s.length();
        for(int i = 0, j = 0;j < len; j++) {
            
            i = Math.max(index[s.charAt(j)], i);
            
            res = Math.max(res, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return res;
    }
}

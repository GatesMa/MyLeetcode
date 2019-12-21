class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        int len =  s.length();
        int i = 0, j = 0 ;
        while(i < len && j < len) {
            
            if(!set.contains(s.charAt(j))) {
                res = Math.max(res, j - i + 1);
                set.add(s.charAt(j));
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}

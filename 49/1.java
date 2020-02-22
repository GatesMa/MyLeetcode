class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap<>();
        for(String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }

}

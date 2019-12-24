class Solution {
    Map<String, String> map = new HashMap(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return list;
        }
        getString("", digits);
        return list;
    }

    public void getString(String str, String digits) {
        if(digits.length() == 0) {
            list.add(str);
            return;
        }
        String digit = digits.substring(0, 1);
        String temp = map.get(digit);
        
        for(int i = 0;i < temp.length();i++) {
            getString(str + temp.substring(i, i + 1), digits.substring(1));
        }
    }
}

class Solution {

    public void backTrack(int len,
                        List<Integer> list,
                        List<List<Integer>> res,int now) {
        if(len == now) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = now;i < len;i++) {
            Collections.swap(list, now, i);
            backTrack(len, list, res, now + 1);
            Collections.swap(list, now, i);
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        for(int i : nums) {
            list.add(i);
        }
        backTrack(len, list, res, 0);
        return res;
    }
}

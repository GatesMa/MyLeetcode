class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i = (int)(Math.pow(2, n));i < (int)(Math.pow(2, n + 1));i++) {
            String submask = Integer.toBinaryString(i).substring(1);
            List<Integer> curr = new ArrayList<>();
            for(int j = 0;j < n;j++) {
                if(submask.charAt(j) == '1') {
                    curr.add(nums[j]);
                }
            }
            res.add(curr);
        }
        return res;
    }
}

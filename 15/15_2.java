class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for(int i = 0;i < len;i++) {
            if(nums[i] > 0) break;
            if(i >= 1 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1;j < len;j ++) {
                for(int k = j + 1;k < len;k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while(k < len - 1 && nums[k] == nums[k + 1]) k++;
                    }
                }
                while(j < len - 1 && nums[j] == nums[j + 1]) j++;
            }
        }
        return res;
    }
}

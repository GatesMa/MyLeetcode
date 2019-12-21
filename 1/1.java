class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        
        for(int i = 0;i < len;i++) {
            int tmp = target - nums[i];
            if(map.containsKey(tmp) && map.get(tmp) != i) {
                return new int[]{i, map.get(tmp)};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}

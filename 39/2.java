class Solution {

    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    int len;

    public void combinationSumHelper(int residue, int start, Stack<Integer> pre) {
        if(residue == 0) {
            res.add(new ArrayList<>(pre));
        } else {
            for(int i = start;i < candidates.length && residue - candidates[i] >= 0;i++) {
                pre.push(candidates[i]);
                combinationSumHelper(residue - candidates[i], i, pre);
                pre.pop();
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if(candidates == null || candidates.length == 0) return res;
        // 优化添加的代码1：先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.len = candidates.length;
        combinationSumHelper(target, 0, new Stack<>());
        return res;
    }


}

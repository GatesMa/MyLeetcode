class Solution {

    public List<List<Integer>> combinationSumHelper(List<List<Integer>> res, int residue, int[] candidates, int start, Stack<Integer> pre) {
        if(residue == 0) {
            res.add(new ArrayList<>(pre));
        } else if(residue < 0) {
            return res;
        } else {
            for(int i = start;i < candidates.length;i++) {
                pre.push(candidates[i]);
                combinationSumHelper(res, residue - candidates[i], candidates, i, pre);
                pre.pop();
            }
        }
        return res;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        // 优化添加的代码1：先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        return combinationSumHelper(res, target, candidates, 0, new Stack<>());
    }


}

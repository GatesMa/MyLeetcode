/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        levelOrderHelper(list, root, 0);
        return list;
    }

    public void levelOrderHelper(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(list.size() < level + 1) {
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(root.val);
        levelOrderHelper(list, root.left, level + 1);
        levelOrderHelper(list, root.right, level + 1);
    }

}

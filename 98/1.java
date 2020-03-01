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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    public boolean isValidBSTHelper(TreeNode root, Integer lower, Integer upper) {
        if(root == null) return true;
        int val = root.val;
        if(lower != null && lower >= val) return false;
        if(upper != null && upper <= val) return false;

        if(!isValidBSTHelper(root.left, lower, val)) return false;
        if(!isValidBSTHelper(root.right, val, upper)) return false;

        return true;
    }


}

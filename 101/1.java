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
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root, root);
    }

    public boolean isSymmetricHelper(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        return node1.val == node2.val && isSymmetricHelper(node1.left, node2.right) 
            && isSymmetricHelper(node1.right, node2.left);
    }
}

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
    public void flatten(TreeNode root) {
        while(root != null) {
            // 如果左结点为空，直接处理下一个结点（右结点）
            if(root.left == null) root = root.right;
            else {
                //获取左结点最右的位置，好把root的右结点接上
                TreeNode pre = root.left;
                while(pre.right != null) {
                    pre = pre.right;
                }
                //root.right接在左结点的最右位置
                pre.right = root.right;
                //把root的左子树，接在右子树
                root.right = root.left;
                //左子树为null
                root.left = null;
                //处理下一个结点
                root = root.right;
            }
        }
    }
}

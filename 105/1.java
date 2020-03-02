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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if(pl > pr) return null;
        if(pr == pl) return new TreeNode(preorder[pl]);
        //找到根结点在中序遍历的下标
        int index = find(inorder, il, ir, preorder[pl]);
        //左子树长度
        int left_len = index - il;
        TreeNode node = new TreeNode(preorder[pl]);
        node.left = buildTreeHelper(preorder, inorder, pl + 1, pl + left_len, il, index - 1);
        node.right = buildTreeHelper(preorder, inorder, pl + left_len + 1, pr, index + 1, ir);
        return node;
    }

    public int find(int[] nums, int i_l, int i_r, int target) {
        for(int i = i_l;i <= i_r;i++) {
            if(nums[i] == target) return i;
        }
        return -1;
    }

}

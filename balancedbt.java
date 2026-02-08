/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] getHeightandBal(TreeNode root)
    {
        if (root==null)
        {
            return new int[] {0, 1};
        }
        int[] lh = getHeightandBal(root.left);
        int[] rh = getHeightandBal(root.right);
        if(lh[1] == 0 || rh[1] == 0)
        {
            return new int[] {0, 0};
        }
        int height = 1 + Math.max(lh[0], rh[0]);
        int bal = Math.abs(lh[0]-rh[0]);
        if(bal>1)
        {
            return new int[] {height, 0};
        }
        else
        {
            return new int[] {height, 1};
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        int[] lh = getHeightandBal(root.left);
        int[] rh = getHeightandBal(root.right);
        int n = lh[0]-rh[0];
        if(lh[1] == 0 || rh[1] == 0 || Math.abs(n)>1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        return lca(root, (p.val < q.val ? p.val : q.val), (p.val > q.val ? p.val : q.val));
    }
    
    private TreeNode lca(TreeNode root, int smaller, int larger){
        if(larger < root.val){
            return lca(root.left, smaller, larger);
        }
        if(smaller > root.val){
            return lca(root.right, smaller, larger);
        }

        return root;
    }
}
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    bool hasPathSumHelper(TreeNode* root, int targetSum) {
        if(!root) return targetSum == 0;
        if(!root->left){
            return hasPathSumHelper(root->right, targetSum - root->val);
        }
        if(!root->right){
            return hasPathSumHelper(root->left, targetSum - root->val);
        }
        return hasPathSumHelper(root->left, targetSum - root->val)
            || hasPathSumHelper(root->right, targetSum - root->val);
    }
    
public:
    bool hasPathSum(TreeNode* root, int targetSum) {
        if(!root) return false;
        
        return hasPathSumHelper(root, targetSum);
    }
};
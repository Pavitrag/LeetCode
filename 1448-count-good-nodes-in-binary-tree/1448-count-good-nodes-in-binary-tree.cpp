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
    int dfs(TreeNode* root, int max){
        int count = 0;
        if(!root) return 0;
        if(root->val >= max){
            count++;   
        }
        count += dfs(root->left, std::max(root->val, max));
        count += dfs(root->right, std::max(root->val, max));
        return count;
    }
public:
    int goodNodes(TreeNode* root) {
        if(!root)   return 0;
        return dfs(root, INT_MIN);
    }
};
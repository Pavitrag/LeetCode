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
    vector<int> values;
    
    void dfs(TreeNode* root){
        if(!root) return;
        inorderTraversal(root->left);
        values.push_back(root->val);
        inorderTraversal(root->right);
    }
public:
    vector<int> inorderTraversal(TreeNode* root) {
        values.reserve(50);
        dfs(root);
        return values;
    }
};
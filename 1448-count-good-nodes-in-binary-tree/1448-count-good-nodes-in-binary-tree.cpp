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
        if(root->val >= max){
            count++;
            if(root->left){
                count += dfs(root->left, root->val);
            }
            if(root->right){
                count += dfs(root->right, root->val);
            }
        }else{
            if(root->left){
                count += dfs(root->left, max);
            }
            if(root->right){
                count += dfs(root->right, max);
            }
        }
        return count;
    }
public:
    int goodNodes(TreeNode* root) {
        if(!root)   return 0;
        return dfs(root, INT_MIN);
    }
};
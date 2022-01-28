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
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> vofvectors;
        if (!root) return {};

        deque<TreeNode*> q;
        q.push_back(root);

        while (!q.empty()) {
            int levelSize = q.size();
            vector<int> level(levelSize);
            for (int index = 0; index < levelSize; index++) {
                TreeNode* curr = q.front();
                q.pop_front();

                level[index] = curr->val;

                if (curr->left) {
                    q.push_back(curr->left);
                }

                if (curr->right) {
                    q.push_back(curr->right);
                }
            }
            vofvectors.push_back(level);
        }
        return vofvectors;
    }
};
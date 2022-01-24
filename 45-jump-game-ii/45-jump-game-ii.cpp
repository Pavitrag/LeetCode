class Solution {
public:
    int jump(vector<int>& nums) {
        const int len = nums.size();
        vector<int> min(len, INT_MAX);

        min[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int k = i; k <= i + nums[i] && k < len; k++) {
                min[k] = std::min(min[k], min[i] + 1);
            }
        }
        return min[len - 1];
    }
};
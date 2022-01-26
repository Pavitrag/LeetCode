class Solution {
public:
    int jump(vector<int>& nums) {
        vector<int>::size_type len = nums.size();
        if(len <= 0) return 0;
        int max = 0, current_max = 0, mjump = 0;
        for (int i = 0; i < len; i++) {
            if(i > current_max){
                mjump++;
                current_max = max;
            }
            max = std::max(max, i + nums[i]);
        }
        return mjump;
    }
};
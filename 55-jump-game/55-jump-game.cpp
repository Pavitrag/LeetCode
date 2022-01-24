class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.size() == 0){
            return false;
        }
        int farthest = nums[0];
        int i = 0;
        while(i <= farthest){
            farthest = std::max(farthest, i + nums[i]);
            if(farthest >= nums.size()-1){
                return true;
            }
            i++;
        }
        return false;
    }
};
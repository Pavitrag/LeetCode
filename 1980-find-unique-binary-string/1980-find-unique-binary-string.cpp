class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        string different{""};
        int len = 0;
        for(int i=0;i<nums.size();i++){
            if(nums[i][len++] == '0'){
                different.push_back('1');
            }else{
                different.push_back('0');
            }
        }
        return different;
    }
};
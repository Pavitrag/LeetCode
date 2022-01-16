class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> missings;
        int index = 0;
        for(int i=0; i< nums.size(); i++){
            int index = nums[i];
            index = abs(index) - 1;
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        
        for(int i=0; i< nums.size(); i++){
            if(nums[i] > 0){
                missings.push_back(i+1);
            }
        }
        return missings;
    }
    
    void swap(vector<int>& nums, int f, int s){
        int t = nums[f];
        nums[f] = nums[s];
        nums[s] = t;
    }
};
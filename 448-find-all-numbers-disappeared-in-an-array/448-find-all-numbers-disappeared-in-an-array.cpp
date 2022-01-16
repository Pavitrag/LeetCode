class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> missings;
        int index = 0;
        while(index < nums.size()){
            if((nums[index] != index+1) && (nums[index] != nums[nums[index]-1])){
                swap(nums, index, nums[index]-1);
            }else{
                index++;
            }
        }
        
        for(int i=0; i< nums.size(); i++){
            if(nums[i] != i+1){
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
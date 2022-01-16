/** IDEA: For each number seen make the number at the corresponding index as negative if not already negative.
For example it the number seen at index 'i' is nums[i] then make nums[nums[abs(i)-1]] *= -1; (if not already negative.)

Therefore while traversing through the array again if we see any number positive it means its corresponding index number which is (index+1) was never seen.
And hence it can be added to the output vector.
 
*/
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

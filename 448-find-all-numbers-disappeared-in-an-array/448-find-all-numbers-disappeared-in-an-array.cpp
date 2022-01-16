class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        const int MAX = 100001;
        vector<int> missings;
        bool present[MAX] = {false,};
        
        for(int e: nums){
            present[e] = true;
        }
        for(int i = 1; i< nums.size()+1; i++){
            if(!present[i]){
                missings.push_back(i);
            }
        }
        return missings;
    }
};
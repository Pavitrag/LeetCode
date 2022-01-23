class Solution {
    int convertToInt(const string& s) {
      int toInt = 0;
      for (const auto& c : s) {
        if (toInt & (1 << (c - 'a'))){ //if the bit is already set means that character is repeated in this string and hence it should not be considered
            return 0;
        }
        toInt |= (1 << (c - 'a'));
      }
      return toInt;
    }
    
    //doing it in O(N**2)
    int maxLen(vector<string>& arr){
        int maxLength = 0;
        vector<string> concats{string("")};
        for(int i = 0; i< arr.size(); i++){
            int num = convertToInt(arr[i]);
            if(num == 0){
                continue;
            }
            for(int j=0; j< concats.size(); j++){
                int c = convertToInt(concats[j]);
                if(!(num & c)){//no overlap chars
                    string curr = concats[j] + arr[i];
                    concats.push_back(curr);
                    maxLength = std::max(maxLength, (int)curr.length());
                }
            }
        }
        return maxLength;
    }
    
public:
    int maxLength(vector<string>& arr) {
        return maxLen(arr);
    }
};
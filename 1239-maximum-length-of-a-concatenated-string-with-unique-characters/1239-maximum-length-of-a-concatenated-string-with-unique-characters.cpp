class Solution {
    inline bool isOverlap(int i, int j) { return i & j; }
    
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
    
    unordered_map<string, int> stringToIntegers(const vector<string>& strings) {
      unordered_map<string, int> m;
      for (const auto& s : strings) {
        m.insert(make_pair(s, convertToInt(s)));
      }
      return m;
    }
    
    int backtrack(int solution, const vector<string>& strings, const unordered_map<string, int>& m, int len, int maxl, int index) {
          if (index >= strings.size()) {
            return maxl = std::max(maxl, len);
          }

          int currentStringNumber = m.at(strings[index]);
          int max = INT_MIN;
          if (!isOverlap(currentStringNumber, solution)) {
            int thislen = strings[index].length();
            max = backtrack((solution | currentStringNumber), strings, m, len + thislen, maxl,
                            index+1);
          }
          return max =
                     std::max(max, backtrack(solution, strings, m, len, maxl, index+1));
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
        // vector<string> uarr;
        //   for (const auto& s : arr) {
        //     if (convertToInt(s)) {
        //       uarr.push_back(s);
        //     }
        //   }
        // unordered_map<string, int> m = stringToIntegers(uarr);  // contains mapping from string to its bit calculated number.
        // return backtrack(0, uarr, m, 0, 0, 0);
    }
};
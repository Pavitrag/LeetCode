class Solution {
public:
    int minDeletions(string s) {
        sort(begin(s), end(s));
        map<int, int> f;
        int minChars = 0;
        int index = 0;
        while (index < s.length()) {
            int count = 1;
            char curr = s[index++];
            while (index < s.length() && s[index] == curr) {
                index++;
                count++;
            }
            while (count > 0 && f[count] >= 1) {
                minChars++;
                count--;
            }
            if (count > 0) {
                f[count]++;
            }
        }
        return minChars;
    }
};
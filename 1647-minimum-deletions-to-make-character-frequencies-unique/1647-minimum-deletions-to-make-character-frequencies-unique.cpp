class Solution {
public:
    int minDeletions(string s) {
        int count[26]{ 0, };
        for (auto& e : s) {
            count[e - 'a']++;
        }
        unordered_map<int, int> f;
        int minChars = 0;
        for (int i = 0; i < 26; i++) {
            int cnt = count[i];
            if (cnt == 0) continue;
            if (!f[cnt]) {
                f[cnt]++;
            }
            else {
                while (cnt > 0 && f[cnt] >= 1) {
                    minChars++;
                    cnt--;
                }
                if (cnt > 0) {
                    f[cnt]++;
                }
            }
        }
        return minChars;
    }
};
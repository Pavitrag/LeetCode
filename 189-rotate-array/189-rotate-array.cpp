class Solution {
public:
    void rotate(vector<int>& arr, int r) {
        int len = arr.size();
        r %= len;
        // if (r > len){
        //     reverse(begin(arr), end(arr));
        //     return;
        // }
        reverse(begin(arr), begin(arr) + len - r);
        reverse(begin(arr) + len - r, end(arr));
        reverse(begin(arr), end(arr));
        // if (r > len - r) { //do left rotation instead of right
        //     r = len - r;
        //     for (int i = 0; i < r; i++) {
        //         int f = i, s = i + r;
        //         while (s < len) {
        //             std::swap(arr[f], arr[s]);
        //             f = s;
        //             s = f + r;
        //         }
        //     }
        // } else { // rotate right
        //     for (int i = len-r; i < len; i++) {
        //         int f = i, s = i - r;
        //         while (s >= 0) {
        //             std::swap(arr[f], arr[s]);
        //             f = s;
        //             s = f - r;
        //         }
        //     }
        // }
        return;
    }
};
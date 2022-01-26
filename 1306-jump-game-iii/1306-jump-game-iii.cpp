class Solution {
public:
    bool canReach(vector<int>& arr, int start) {
        int len = arr.size();
        stack<int> stk;
        set<int> visited;
        stk.push(start);
        
        while(!stk.empty()){
            int index = stk.top(); 
            stk.pop();
            if(arr[index] == 0){
                return true;
            }
            int nxt = index + arr[index];
            if(nxt >= 0 && nxt < len && visited.find(nxt) == end(visited)){
                visited.emplace(nxt);
                stk.push(nxt);
            }
            int prev = index - arr[index];
            if(prev >= 0 && prev < len && visited.find(prev) == end(visited)){
                visited.emplace(prev);
                stk.push(prev);
            }
        }
        return false;
    }
};
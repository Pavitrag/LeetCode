class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(candidates, result, new ArrayList<>(), 0, target);
        return result;
    }
    
    private static void solve(int[] candidates, List<List<Integer>> result, List<Integer> temp
                , int index, int target){
            if(target < 0){
                return;
            }
            if(target == 0){
                result.add(new ArrayList<>(temp));
                return;
            }
            int len = candidates.length;
            for(int i = index; i < len; i++){
                temp.add(candidates[i]);
                solve(candidates, result, temp, i, target - candidates[i]);
                temp.remove(temp.size()-1);
            }
        }
}
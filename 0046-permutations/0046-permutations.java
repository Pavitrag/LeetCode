class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] taken = new boolean[nums.length];
        solve(nums, result, taken, new ArrayList<>());
        return result;
    }
    
    private void solve(int[] nums, List<List<Integer>> result, boolean[] taken, List<Integer> current){
        if(current.size() == nums.length){
            result.add(new ArrayList<Integer>(current));
            return;
        }
        List<Integer> candidates = new ArrayList<>();
        for(int i = 0; i < taken.length; i++){
            if(!taken[i]){
                taken[i] = true;
                current.add(nums[i]);
                solve(nums, result, taken, current);
                current.remove(current.size()-1);
                taken[i] = false;
            }
        }
    }
}
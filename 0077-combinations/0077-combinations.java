class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> input = new ArrayList<>();
        IntStream.rangeClosed(1, n).forEach(i -> input.add(i));
        return myCombos(input, k);
    }
    
    private List<List<Integer>> myCombos(List<Integer> in, int count){
            List<List<Integer>> result = new ArrayList<>();
            int len = in.size();
            if(count == 0){
                return result;
            }
            if(len <= count){
                result.add(in);
                return result;
            }
            var with = myCombos(in.subList(1, in.size()), count-1);
            if(with.size() == 0){
                List<Integer> curr = new ArrayList<>();
                curr.add(in.get(0));
                result.add(curr);
            }else {
                for (var o : with) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(in.get(0));
                    curr.addAll(o);
                    result.add(curr);
                }
            }
            var without = myCombos(in.subList(1, in.size()), count);
            result.addAll(without);
            return result;
        }
}
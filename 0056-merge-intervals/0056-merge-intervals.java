class Solution {
    public int[][] merge(int[][] intervals) {
        //O(n.log(n))
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        //record Interval(int s, int e) {/* DO NOTHING */}

        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prev = result.get(result.size()-1);
            if(curr[0] <= prev[1]){
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            }else{
                result.add(curr);
            }
        }

        return result.toArray(new int[result.size()][]);
    }//:~
}
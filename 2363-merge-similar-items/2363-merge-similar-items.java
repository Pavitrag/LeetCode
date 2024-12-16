class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(items1, (p, q) -> p[0] - q[0]);
        Arrays.sort(items2, (p, q) -> p[0] - q[0]);
        int p1=0, p2=0;
        while(p1 < items1.length && p2 < items2.length){
            if(items1[p1][0] == items2[p2][0]){
                out.add(List.of(items1[p1][0], items1[p1][1] + items2[p2][1]));
                p1++;
                p2++;
            }else if(items1[p1][0] < items2[p2][0]){
                out.add(List.of(items1[p1][0], items1[p1][1]));
                p1++;
            }else{
                out.add(List.of(items2[p2][0], items2[p2][1]));
                p2++;
            }
        }
        while(p1 < items1.length){
            out.add(List.of(items1[p1][0], items1[p1][1]));
            p1++;
        }
        while(p2 < items2.length){
            out.add(List.of(items2[p2][0], items2[p2][1]));
            p2++;
        }
        return out;
    }
}
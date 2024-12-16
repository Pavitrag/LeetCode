class Solution {
    
    private record Pair(int id, int val){}
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        List<Pair> out = new ArrayList<>();
        int i = 0, j = 0;

        for(; i < len1 && j < len2; /*no-op*/){
            if(nums1[i][0] < nums2[j][0]){
                out.add(new Pair(nums1[i][0], nums1[i][1]));
                i++;
            }else if (nums1[i][0] > nums2[j][0]){
                out.add(new Pair(nums2[j][0], nums2[j][1]));
                j++;
            }else{
                out.add(new Pair(nums1[i][0], nums1[i][1]+nums2[j][1]));
                i++; j++;
            }
        }
        for(; i < len1; i++){
            out.add(new Pair(nums1[i][0], nums1[i][1]));
        }
        for(; j < len2; j++){
            out.add(new Pair(nums2[j][0], nums2[j][1]));
        }
        
        return out.stream().map(pair -> new int[]{pair.id(), pair.val()})
                .toArray(int[][]::new);
    }
}
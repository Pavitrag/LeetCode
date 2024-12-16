class Solution {
    
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        record Pair(int id, int val){}
        int len1 = nums1.length;
        int len2 = nums2.length;
        List<int[]> out = new ArrayList<>();
        int i = 0, j = 0;

        while(i < len1 && j < len2){
            if(nums1[i][0] < nums2[j][0]){
                out.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            }else if (nums1[i][0] > nums2[j][0]){
                out.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            }else{
                out.add(new int[]{nums1[i][0], nums1[i][1]+nums2[j][1]});
                i++; j++;
            }
        }
        while(i < len1){
            out.add(new int[]{nums1[i][0], nums1[i][1]});
            i++;
        }
        while(j < len2){
            out.add(new int[]{nums2[j][0], nums2[j][1]});
            j++;
        }
        return out.toArray(new int[out.size()][2]);
        // return out.stream().map(pair -> new int[]{pair.id(), pair.val()})
        //         .toArray(int[][]::new);
    }
}
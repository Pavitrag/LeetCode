class Solution {
    public int maximumProduct(int[] nums) {
        int lo1=Integer.MAX_VALUE, lo2=Integer.MAX_VALUE, m3=Integer.MIN_VALUE, m2=Integer.MIN_VALUE, m1=Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            int v = nums[i];
            if(v >= m1){
                m3 = m2;
                m2 = m1;
                m1 = v;
            }else if(v >= m2){
                m3= m2;
                m2= v;
            }else if(v >= m3){
                m3 = v;
            }
            
            if(v <= lo1){
                lo2= lo1;
                lo1 = v;
            }else if(v <= lo2){
                lo2 = v;
            }
        }
        return Math.max(lo1*lo2*m1, m1*m2*m3);
    }
}
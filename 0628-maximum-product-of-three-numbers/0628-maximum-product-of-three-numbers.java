class Solution {
    public int maximumProduct(int[] nums) {
        int lo1, lo2, m3=0, m2=0, m1=0;
        assert nums.length >= 3;
        int a = nums[0], b = nums[1], c = nums[2];
        if(a <= b){
            if(b <= c){
                m1 = c;
                m2 = b;
                m3 = a;
            }else{
                 m1 = b;
                if(a <= c){
                    m2 = c;
                    m3 = a;
                }else{
                    m2 = a;
                    m3 = c;
                }
            }
        }else{ //a > b
            if(c <= a){
                m1 = a;
                if(b < c){
                    m3 = b;
                    m2 = c;
                }else{
                    m3 = c;
                    m2 = b;
                }
            }else{ // c>= a
                m1 = c;
                m2 = a;
                m3 = b;
            }
        }

        lo1 = m3;
        lo2 = m2;

        for(int i = 3; i < nums.length; i++){
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
            }else if(v <= lo1){
                lo2= lo1;
                lo1 = v;
            }else if(v <= lo2){
                lo2 = v;
            }
        }
        return Math.max(lo1*lo2*m1, m1*m2*m3);
    }
}
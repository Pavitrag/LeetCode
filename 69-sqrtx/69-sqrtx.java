class Solution {
    public int mySqrt(int x) {
        if(x == 1) return x;
        double lo = 0;
        double hi = x;

        double precision = 0.00001;
        double mid= 0.0;
        while(lo < hi) {
            mid = lo + (hi - lo)/2;
            if(Math.abs(mid * mid - x) < precision) {
                return (int)mid;
            } else if(mid * mid < x) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return (int)mid;
      }
}
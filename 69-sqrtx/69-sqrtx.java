class Solution {
    public int mySqrt(int x) {
        if (x <= 1)
          return x;
        double xx = x;
        double lo = 0.0, hi = x;
        while (lo < hi) {
          double mid = lo + (hi - lo) / 2;
          if ((long) xx == (long) (mid * mid)) {
            return (int) mid;
          }
          if (x < mid * mid) {
            hi = mid;
          } else {
            lo = mid;
          }
        }
        return (int) lo;
      }
}
class Solution {
    private double powerLog(double x, long y) {
        if (y == 0)
            return 1;
        if (y % 2 == 0) {
            double ret = powerLog(x, y / 2);
            return ret*ret;
        }
        return powerLog(x, y - 1)*x;
    }
    
    public double myPow(double x, int n) {
        long ln = n;
        if(n < 0){
            return 1.0/powerLog(x, -ln);
        }
        return powerLog(x, ln);    
    }
}
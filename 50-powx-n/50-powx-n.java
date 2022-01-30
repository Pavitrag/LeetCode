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
    
    /**See Notes for explanation 
     Logrithmic, iterative approach
     Time complexity: O(log(y)*/
    private double powerLogIterative(double x, long y) {
        long prev = 1;
        long itr = 1;
        if (y == 0) return 1;
        double accumulated = 1;
        double curr = 1;
        while (itr <= y) {
            prev = itr;//prev to record when itr value exceeds the exponent y. So that the prev can be reduced from y.
            if (itr % 2 == 0) {
                curr *= curr;
                itr *= 2;
            } else {
                curr *= x;
                itr++;
            }
            if(itr > y){
                accumulated *= curr;
                y -= prev;
                itr = 1;
                curr = 1;
            }
        }
        return accumulated;
    }
    
    public double myPow(double x, int n) {
        long ln = n;
        if(n < 0){
            return 1.0/powerLogIterative(x, -ln);
        }
        return powerLogIterative(x, ln);    
    }
}
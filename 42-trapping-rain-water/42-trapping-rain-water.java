class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int left = 0, right = len-1;
        int leftMax = 0, rightMax = 0;

        int water = 0;
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            
            if(leftMax < rightMax){
                water += leftMax - height[left];
                left++;
            }else{
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
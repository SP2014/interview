class TrappingRainWater{
    public static int trap(int[] height){
        int water = 0;
        int leftIndex = 0;
        int rightIndex = height.length-1;

        int leftMax = 0;
        int rightMax = 0;

        while(leftIndex <= rightIndex){
            leftMax = Math.max(leftMax, height[leftIndex]);
            rightMax = Math.max(rightMax, height[rightIndex]);

            if(leftMax < rightMax){
                water+= leftMax - height[leftIndex];
                leftIndex+=1;
            }
            else{
                water+= rightMax - height[rightIndex];
                rightIndex-=1;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
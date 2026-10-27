class Solution {
    public int trap(int[] height) {
        int l=height.length;
        int[] maxL=new int[l],maxR=new int[l];
        int total=0;
        for(int i=1;i<l;i++){
            maxL[i]=Math.max(maxL[i-1],height[i-1]);
        }
        for(int i=l-2;i>=0;i--){
            maxR[i]=Math.max(maxR[i+1],height[i+1]);
        }
        for(int i=1;i<l-1;i++){
            int min=Math.min(maxL[i],maxR[i]);
            int h=height[i];
            if(min>h){
                total+=min-h;
            }
        }
        return total;
    }
}

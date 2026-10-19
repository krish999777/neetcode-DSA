class Solution {
    public int findMin(int[] nums) {
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        int l=0,r=n-1;
        while(l<=r){
            if(nums[l]<nums[r]){
                min=Math.min(min,nums[l]);
            }
            int mid=(l+r)/2;
            min=Math.min(min,nums[mid]);
            if(nums[mid]>=nums[l]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return min;
    }
}
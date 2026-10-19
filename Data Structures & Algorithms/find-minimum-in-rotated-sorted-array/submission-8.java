class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int l=0,r=n-1;
        if(nums[l]<nums[r]){
            return nums[l];
        }
        l++;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]<nums[mid-1]){
                return nums[mid];
            }else if(nums[mid]>nums[r]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }
}

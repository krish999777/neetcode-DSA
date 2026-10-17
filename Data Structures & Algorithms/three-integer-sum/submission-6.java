class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int negIndex=0;
        while(negIndex<nums.length&&nums[negIndex]<=0){
            negIndex++;
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<negIndex;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int target=-(nums[i]);
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int left=nums[l];
                int right=nums[r];
                int sum=left+right;
                if(sum==target){
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i],left,right)));
                    l++;
                    r--;
                    while(l<nums.length&&left==nums[l]){
                        l++;
                    }
                    while(r>=0&&right==nums[r]){
                        r--;
                    }
                }else if(sum>target){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return result;
    }
}

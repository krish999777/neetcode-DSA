class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int l=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<l&&nums[i]<=0;i++){
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            int num1=nums[i];
            int left=i+1;
            int right=l-1;
            while(left<right){
                int sum=num1+nums[left]+nums[right];
                if(sum==0){
                    res.add(List.of(num1,nums[left],nums[right]));
                    do{
                        left++;
                    }while(left<right&&nums[left]==nums[left-1]);
                    do{
                        right--;
                    }while(left<right&&nums[right]==nums[right+1]);
                }else if(sum>0){
                    right--;// we can optimize this
                }else{
                    left++;
                }
            }
        }
        return res;
    }
}

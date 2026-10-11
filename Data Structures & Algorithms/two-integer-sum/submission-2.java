class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> values=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(values.containsKey(target-nums[i])){
                int ar[]={values.get(target-nums[i]),i};
                return ar;
            }
            values.put(nums[i],i);
        }
        return new int[0];
    }
}

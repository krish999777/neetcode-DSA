class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(0,0,target,new ArrayList<>(),res,nums);
        return res;
    }
    private void dfs(int s,int sum,int target,List<Integer> cur,List<List<Integer>> res,int[] nums){
        if(sum>=target){
            if(sum==target){
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for(int i=s;i<nums.length;i++){
            cur.add(nums[i]);
            dfs(i,sum+nums[i],target,cur,res,nums);
            cur.remove(cur.size()-1);
        }
    }
}
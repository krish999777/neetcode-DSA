class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>(),res);
        return res;
    }
    private void dfs(int[] nums,int i,List<Integer> cur,List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        dfs(nums,i+1,cur,res);
        cur.remove(cur.size()-1);
        while(i+1<nums.length&&nums[i]==nums[i+1]) i++;
        dfs(nums,i+1,cur,res);
    }
}

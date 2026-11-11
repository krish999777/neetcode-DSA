class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res=new ArrayList<>();
        dfs(0,nums,new ArrayList<>());
        return res;
    }
    private void dfs(int i,int[] nums,List<Integer> sub){
        if(i==nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[i]);
        dfs(i+1,nums,sub);
        sub.remove(sub.size()-1);
        dfs(i+1,nums,sub);
    }
}
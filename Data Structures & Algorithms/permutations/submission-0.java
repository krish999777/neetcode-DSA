class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        List<List<Integer>> res=new ArrayList<>();
        dfs(set,new ArrayList<>(),res,nums);
        return res;
    }
    private void dfs(Set<Integer> set,List<Integer> cur,List<List<Integer>>res,int[] nums){
        if(set.size()==0){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int num:nums){
            if(!set.contains(num)) continue;
            set.remove(num);
            cur.add(num);
            dfs(set,cur,res,nums);
            set.add(num);
            cur.remove(cur.size()-1);
        }
    }
}

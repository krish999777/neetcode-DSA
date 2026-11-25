class Solution {
    public boolean validTree(int n, int[][] edges) {
        // @SuppressWarnings("unchecked")
        if(n==1){
            return true;
        }
        List<Integer>[] adjacent=new List[n];
        for(int i=0;i<n;i++){
            adjacent[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            adjacent[edge[0]].add(edge[1]);
            adjacent[edge[1]].add(edge[0]);
        }
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            if(!dfs(adjacent,i,-1,set)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(List<Integer>[] adjacent,int i,int par,Set<Integer> visited){
        if(adjacent[i].size()==0){
            return false;
        }
        if(adjacent[i].size()==1&&adjacent[adjacent[i].get(0)].size()==1){
            return false;
        }
        visited.add(i);
        for(int child:adjacent[i]){
            if(child==par){
                continue;
            }
            if(visited.contains(child)){
                return false;
            }
            dfs(adjacent,child,i,visited);
        }
        visited.remove(i);
        return true;
    }
}

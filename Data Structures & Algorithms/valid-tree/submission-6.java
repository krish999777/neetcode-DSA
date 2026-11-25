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
        return dfs(adjacent,0,-1,set)&&set.size()==n;
    }
    private boolean dfs(List<Integer>[] adjacent,int i,int par,Set<Integer> visited){

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
        return true;
    }
}

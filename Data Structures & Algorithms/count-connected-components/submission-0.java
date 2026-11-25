class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacent=new ArrayList<>();
        int count=0;
        for(int i=0;i<n;i++){
            adjacent.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited=new HashSet<>();
        for(int i=0;i<n;i++){
            count+=dfs(adjacent,i,visited)?1:0;
        }
        return count;
    }
    private boolean dfs(List<List<Integer>> adjacent,int i,Set<Integer> visited){
        if(visited.contains(i)){
            return false;
        }
        visited.add(i);
        for(int next:adjacent.get(i)){
            dfs(adjacent,next,visited);
        }
        return true;
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacent=new List[numCourses];
        for(int i=0;i<numCourses;i++){
            adjacent[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            adjacent[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        Set<Integer> set=new HashSet<>();
        boolean[] reachable=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!reachable[i]&&!dfs(adjacent,i,set,reachable)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(List<Integer>[] adjacent,int i,Set<Integer> set,boolean[] reachable){
        if(set.contains(i)){
            return reachable[i];
        }
        set.add(i);
        for(int req:adjacent[i]){
            if(!dfs(adjacent,req,set,reachable)){
                return false;
            }
        }
        reachable[i]=true;
        return true;
    }
}
class Solution {
    int cur;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res=new int[numCourses];
        int[] status=new int[numCourses];
        cur=0;
        List<Integer>[] adjacent=new List[numCourses];
        for(int i=0;i<numCourses;i++){
            adjacent[i]=new ArrayList<>();
        }
        for(int[] prerequisite:prerequisites){
            adjacent[prerequisite[0]].add(prerequisite[1]);
        }
        for(int i=0;i<numCourses;i++){
            if(!dfs(adjacent,i,res,status)){
                return new int[]{};
            }
        }
        return res;
    }
    private boolean dfs(List<Integer>[] adjacent,int i,int[] res,int[] status){
        if(status[i]==1){
            return false;
        }
        if(status[i]==2){
            return true;
        }
        status[i]=1;
        for(int course:adjacent[i]){
            if(!dfs(adjacent,course,res,status)){
                return false;
            }
        }
        status[i]=2;
        res[cur++]=i;
        return true;
    }
}
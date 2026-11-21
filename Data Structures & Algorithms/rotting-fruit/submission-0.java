class Solution {
    public int orangesRotting(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        Queue<int[]> queue=new ArrayDeque<>();
        int count=0;
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    count++;
                }
            }
        }
        int time=0;
        while(queue.size()>0&&count>0){
            int size=queue.size();
            for(int counter=0;counter<size;counter++){
                int[] rotten=queue.poll();
                for(int[] direction:directions){
                    int newI=rotten[0]+direction[0];
                    int newJ=rotten[1]+direction[1];
                    if(newI>=0&&newJ>=0&&newI<r&&newJ<c&&
                    grid[newI][newJ]==1){
                        count--;
                        grid[newI][newJ]=2;
                        queue.offer(new int[]{newI,newJ});
                    }
                }
            }
            time++;
        }
        if(count>0){
            return -1;
        }else{
            return time;
        }
    }
}

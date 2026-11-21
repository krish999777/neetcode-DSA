class Solution {
    private int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        Queue<int[]> queue=new ArrayDeque<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int level=1;
        while(queue.size()>0){
            int size=queue.size();
            for(int count=0;count<size;count++){
                int[] coords=queue.poll();
                for(int[] direction:directions){
                    int newI=coords[0]+direction[0],newJ=coords[1]+direction[1];
                    if(newI>=0&&newJ>=0&&newI<r&&newJ<c&&
                    grid[newI][newJ]==Integer.MAX_VALUE){
                        queue.offer(new int[]{newI,newJ});
                        grid[newI][newJ]=level;
                    }
                }
            }
            level++;
        }
    }
}

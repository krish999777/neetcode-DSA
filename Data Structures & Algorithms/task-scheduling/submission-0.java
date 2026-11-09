class Solution {
    public int leastInterval(char[] tasks, int n) {
        int counter[]=new int[26];
        List<Integer> charCount=new ArrayList<>();
        for(char ch:tasks){
            counter[ch-'A']--;
        }
        for(int c:counter){
            if(c<0){
                charCount.add(c);
            }
        }
        PriorityQueue<Integer> heap=new PriorityQueue<>(charCount);
        Queue<int[]> queue=new ArrayDeque<>();
        int time=0;
        while(heap.size()>0||queue.size()>0){
            if(heap.size()>0){
                int count=heap.poll();
                if(count+1!=0){
                    queue.offer(new int[]{count+1,time+n});
                }
            }
            if(queue.size()>0&&queue.peek()[1]==time){
                heap.add(queue.poll()[0]);
            }
            time++;
        }
        return time;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<List<Integer>> deque=new ArrayDeque<>();
        int l=nums.length;
        int result[]=new int[l-k+1];
        int r=k;
        for(int i=0;i<r;i++){
            int num=nums[i];
            while(!deque.isEmpty()&&deque.peek().get(0)<num){
                deque.pop();
            }
            deque.push(List.of(num,i));
        }
        result[0]=deque.peekLast().get(0);
        while(r<l){
            if(deque.peekLast().get(1)==r-k){
                deque.removeLast();
            }
            int num=nums[r];
            while(!deque.isEmpty()&&deque.peek().get(0)<num){
                deque.pop();
            }
            deque.push(List.of(num,r));
            result[r-k+1]=deque.getLast().get(0);
            r++;
        }
        return result;
    }
}
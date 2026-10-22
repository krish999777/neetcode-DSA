class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque=new ArrayDeque<>();
        int l=nums.length;
        int result[]=new int[l-k+1];
        int r=k;
        for(int i=0;i<r;i++){
            int num=nums[i];
            while(!deque.isEmpty()&&nums[deque.peek()]<num){
                deque.pop();
            }
            deque.push(i);
        }
        result[0]=nums[deque.peekLast()];
        while(r<l){
            if(deque.peekLast()==r-k){
                deque.removeLast();
            }
            int num=nums[r];
            while(!deque.isEmpty()&&nums[deque.peek()]<num){
                deque.pop();
            }
            deque.push(r);
            result[r-k+1]=nums[deque.getLast()];
            r++;
        }
        return result;
    }
}
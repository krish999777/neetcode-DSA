class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(deque.size()>0&&nums[deque.peek()]<=nums[i]){
                deque.pop();
            }
            deque.push(i);
        }
        int l=nums.length;
        int[] res=new int[l-k+1];
        res[0]=nums[deque.getLast()];
        int index=1;
        System.out.println(deque);
        while(index<l-k+1){
            int i=index+k-1;
            if(deque.getLast()<index){
                deque.removeLast();
            }
            while(deque.size()>0&&nums[deque.peek()]<=nums[i]){
                deque.pop();
            }
            deque.push(i);
            res[index++]=nums[deque.getLast()];
            // System.out.println(deque);
        }
        return res;
    }
}
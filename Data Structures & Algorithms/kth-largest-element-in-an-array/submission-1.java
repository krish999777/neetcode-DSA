class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l=nums.length;
        Integer[] boxedNums=new Integer[l];
        for(int i=0;i<l;i++){
            boxedNums[i]=-nums[i];
        }
        
        PriorityQueue<Integer> minheap=new PriorityQueue<>(List.of(boxedNums));
        for(int i=0;i<k-1;i++){
            minheap.poll();
        }
        return -minheap.poll();
    }
}

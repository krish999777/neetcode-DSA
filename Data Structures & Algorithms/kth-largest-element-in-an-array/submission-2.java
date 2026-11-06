class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l=nums.length;
        List<Integer> listNums=new ArrayList<>();;
        for(int i=0;i<l;i++){
            listNums.add(-nums[i]);
        }
        
        PriorityQueue<Integer> minheap=new PriorityQueue<>(listNums);
        for(int i=0;i<k-1;i++){
            minheap.poll();
        }
        return -minheap.poll();
    }
}

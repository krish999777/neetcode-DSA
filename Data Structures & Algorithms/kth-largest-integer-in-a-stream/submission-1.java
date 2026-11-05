class KthLargest {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        heap=new PriorityQueue<>();
        for(int num:nums){
            if(heap.size()<k){
                heap.add(num);
            }else if(heap.peek()<num){
                heap.poll();
                heap.add(num);
            }
        }
    }
    
    public int add(int val) {
        if(heap.size()<k){
            heap.add(val);
        }
        else if(val>heap.peek()){
            heap.poll();
            heap.add(val);
        }
        return heap.peek();
    }
}

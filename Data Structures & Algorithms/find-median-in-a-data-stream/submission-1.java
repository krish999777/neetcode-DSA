class MedianFinder {
    PriorityQueue<Integer> smallheap,largeheap;
    public MedianFinder() {
        smallheap=new PriorityQueue<>(Collections.reverseOrder());
        largeheap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(smallheap.size()==0||num<smallheap.peek()){
            smallheap.add(num);
        }else{
            largeheap.add(num);
        }
        if(smallheap.size()-1>largeheap.size()){
            largeheap.add(smallheap.poll());
        }else if(largeheap.size()>smallheap.size()){
            smallheap.add(largeheap.poll());
        }
    }
    
    public double findMedian() {
        if(smallheap.size()==largeheap.size()){
            return (smallheap.peek().intValue()+largeheap.peek())/2.0;
        }else{
            return smallheap.peek();
        }
    }
}

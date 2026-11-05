class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> list=new ArrayList<>();
        for(int num:stones){
            list.add(num);
        }
        heap.addAll(list);
        while(heap.size()>1){
            int s1=heap.poll();
            int s2=heap.poll();
            if(s1!=s2){
                heap.add(Math.abs(s1-s2));
            }
        }
        return heap.size()==0?0:heap.peek();
    }
}

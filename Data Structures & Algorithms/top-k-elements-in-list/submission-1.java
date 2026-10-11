class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        List<List<Integer>> l=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            l.add(Arrays.asList(entry.getKey(),entry.getValue()));
        }
        l.sort(Comparator.comparing((List<Integer> entry) -> entry.get(1)).reversed());
        int ar[]=new int[k];
        for(int i=0;i<k;i++){
            ar[i]=l.get(i).get(0);
        }
        return ar;
    }
}

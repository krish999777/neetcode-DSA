class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.compute(num,(key,v)->v==null?1:v+1);
        }
        List<List<Integer>> entries=new ArrayList<>();
        int count=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            entries.add(List.of(entry.getValue(),entry.getKey()));
        }
        entries.sort((a,b)->b.get(0)-a.get(0));
        int res[]=new int[k];
        for(int i=0;i<k;i++){
            res[i]=entries.get(i).get(1);
        }
        return res;
    }
}

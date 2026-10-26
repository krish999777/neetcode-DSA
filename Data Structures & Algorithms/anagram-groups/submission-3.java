class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int l=strs.length;
        String count[]=new String[l];
        for(int i=0;i<l;i++){
            String str=strs[i];
            int countInt[]=new int[26];
            for(char ch:str.toCharArray()){
                countInt[ch-'a']++;
            }
            count[i]=Arrays.toString(countInt);
        }
        Map<String,List<String>> map=new HashMap<>();
        for(int i=0;i<l;i++){
            map.computeIfAbsent(count[i],(k)->new ArrayList<>())
            .add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
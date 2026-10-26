class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int l=strs.length;
        Map<String,List<String>> map=new HashMap<>();
        for(int i=0;i<l;i++){
            String str=strs[i];
            int countInt[]=new int[26];
            for(char ch:str.toCharArray()){
                countInt[ch-'a']++;
            }
            map.computeIfAbsent(
                Arrays.toString(countInt),
                (k)->new ArrayList<>()
            ).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
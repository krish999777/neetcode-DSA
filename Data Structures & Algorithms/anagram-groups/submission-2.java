class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,List<String>> allHashes=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String name=strs[i];
            HashMap<Character,Integer> m=new HashMap<>();
            for(int j=0;j<name.length();j++){
                char ch=name.charAt(j);
                m.put(ch,m.getOrDefault(ch,0)+1);
            }
            List<String> l=allHashes.getOrDefault(
                m,
                new ArrayList<String>()
            );
            l.add(strs[i]);
            allHashes.put(
                m,
                l
            );
        }
        List<List<String>> allAnagrams=new ArrayList<>(allHashes.values());
        return allAnagrams;
    }
}
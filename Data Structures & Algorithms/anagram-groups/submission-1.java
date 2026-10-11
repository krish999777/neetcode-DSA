class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,List<Integer>> allHashes=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String name=strs[i];
            HashMap<Character,Integer> m=new HashMap<>();
            for(int j=0;j<name.length();j++){
                char ch=name.charAt(j);
                m.put(ch,m.getOrDefault(ch,0)+1);
            }
            List<Integer> l=allHashes.getOrDefault(
                m,
                new ArrayList<Integer>()
            );
            l.add(i);
            allHashes.put(
                m,
                l
            );
        }
        List<List<String>> allAnagrams=new ArrayList<>();
        for(Map.Entry<HashMap<Character,Integer>,List<Integer>> m:allHashes.entrySet()){
            List<Integer> indices=m.getValue();
            List<String> names=new ArrayList<>();
            for(int index:indices){
                names.add(strs[index]);
            }
            allAnagrams.add(names);
        }
        return allAnagrams;
    }
}

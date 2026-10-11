class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> sHash=new HashMap<>();
        HashMap<Character,Integer> tHash=new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            sHash.put(c,sHash.getOrDefault(c,0)+1);
        }

        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            tHash.put(c,tHash.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character, Integer> entry : sHash.entrySet()){
            if(!entry.getValue().equals(tHash.get(entry.getKey()))){
                return false;
            }
        }
        return true;
    }
}

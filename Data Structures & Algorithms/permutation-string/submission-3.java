class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count=new int[26];
        for(char ch:s1.toCharArray()){
            s1Count[ch-'a']+=1;
        }
        int l=0,r=s1.length()-1;
        // int[] s2Count=new int[26];//is this better?
        while(r<s2.length()){
            int[] s2Count=new int[26];// or this 
            // Arrays.fill(s2Count,0);//while removing this
            for(int i=l;i<=r;i++){
                s2Count[s2.charAt(i)-'a']+=1;
            }
            System.out.println(Arrays.toString(s2Count));
            if(Arrays.equals(s1Count,s2Count)){
                // System.out.println
                return true;
            }
            l++;
            r++;
        }
        return false;
    }
}
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1=s1.length(),l2=s2.length();
        if(l1>l2){
            return false;
        }
        int[] count1=new int[26];
        int[] count2=new int[26];
        for(int i=0;i<l1;i++){
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }
        int matches=0;
        for(int i=0;i<26;i++){
            if(count1[i]<=count2[i]){
                matches++;
            }
        }
        if(matches==26){
            return true;
        }
        for(int i=l1;i<l2;i++){
            System.out.println(matches);
            int removed=s2.charAt(i-l1)-'a';
            if(count2[removed]--==count1[removed]){
                matches--;
            }
            int added=s2.charAt(i)-'a';
            if(++count2[added]==count1[added]){
                matches++;
            }
            if(matches==26){
                return true;
            }
            System.out.println(matches);
        }
        return false;
    }
}

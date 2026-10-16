class Solution {
    public boolean isPalindrome(String s) {
        int l=0,r=s.length()-1;
        while(l<=r){
            char leftCh=s.charAt(l);
            char rightCh=s.charAt(r);
            if(!Character.isLetterOrDigit(leftCh)){
                l++;
            } 
            else if(!Character.isLetterOrDigit(rightCh)) {
                r--;
            }
            else                    if(Character.toLowerCase(leftCh)==Character.toLowerCase(rightCh)){
                l++; 
                r--;
            } 
            else {
                return false;
            }
        }
        return true;
    }
}

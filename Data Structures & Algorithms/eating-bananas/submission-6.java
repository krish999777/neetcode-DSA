class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int pile:piles){
            max=Math.max(pile,max);
        }
        int l=1,r=max;
        int min=max+1;
        while(l<=r){
            int mid=(l+r)/2;
            int count=0;
            for(int pile:piles){
                count+=Math.ceil((double)pile/mid);
            }
            if(count>h){
                l=mid+1;
            }else{
                min=Math.min(min,mid);
                r=mid-1;
            }
        }
        return min;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l=nums.length;
        int[] pre=new int[l];
        int[] post=new int[l];
        pre[0]=1;
        post[l-1]=1;
        for(int i=1;i<l;i++){
            pre[i]=pre[i-1]*nums[i-1];
        }
        for(int i=l-2;i>=0;i--){
            post[i]=post[i+1]*nums[i+1];
        }
        int answers[]=new int[l];
        for(int i=0;i<l;i++){
            answers[i]=pre[i]*post[i];
        }
        return answers; 
    }
}  

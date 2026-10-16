class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l=nums.length;
        int answers[]=new int[l];
        answers[0]=1;
        for(int i=1;i<l;i++){
            answers[i]=answers[i-1]*nums[i-1];
        }
        int prod=1;
        for(int i=l-2;i>=0;i--){
            prod*=nums[i+1];
            answers[i]*=prod;
        }
        return answers; 
    }
}  

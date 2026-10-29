class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack=new ArrayDeque<>();
        int l=temperatures.length;
        int[] result=new int[l];
        for(int i=0;i<l;i++){
            while(stack.size()>0&&temperatures[stack.peek()]<temperatures[i]){
                int index=stack.pop();
                result[index]=i-index;
            }
            stack.push(i);
        }
        return result;
    }
}

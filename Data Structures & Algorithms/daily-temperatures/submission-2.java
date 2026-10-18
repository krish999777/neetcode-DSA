class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack=new ArrayDeque<>();
        int result[]=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            int temp=temperatures[i];
            while(!stack.isEmpty()&&temperatures[stack.peek()]<temp){
                int tIndex=stack.pop();
                result[tIndex]=i-tIndex;
            }
            stack.push(i);
        }
        return result;
    }
}

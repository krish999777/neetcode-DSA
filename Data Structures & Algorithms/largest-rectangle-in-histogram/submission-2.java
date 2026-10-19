class Solution {
    public int largestRectangleArea(int[] heights) {
        int max=0;
        int n=heights.length;
        int[] pre=new int[n]; 
        int[] post=new int[n]; 
        Arrays.fill(pre,-1);
        Arrays.fill(post,n);
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                post[stack.pop()]=i;
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                pre[stack.pop()]=i;
            }
            stack.push(i);
        }
        for(int i=0;i<n;i++){
            max=Math.max(max,heights[i]*(post[i]-pre[i]-1));
        }
        return max;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int l=heights.length;
        int[] left=new int[l],right=new int[l];
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<l;i++){
            while(stack.size()>0&&heights[stack.peek()]>heights[i]){
                right[stack.pop()]=i;
            }
            stack.push(i);
        }
        while(stack.size()>0){
            right[stack.pop()]=l;
        }
        for(int i=l-1;i>=0;i--){
            while(stack.size()>0&&heights[stack.peek()]>heights[i]){
                left[stack.pop()]=i;
            }
            stack.push(i);
        }
        while(stack.size()>0){
            left[stack.pop()]=-1;
        }
        int max=0;
        for(int i=0;i<l;i++){
            max=Math.max(max,(right[i]-left[i]-1)*heights[i]);
        }
        return max;
    }
}

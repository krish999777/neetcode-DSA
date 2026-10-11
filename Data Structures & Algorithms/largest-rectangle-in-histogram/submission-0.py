class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int: 
        stack=[]
        maxarea=0
        for i,h in enumerate(heights):
            index=i
            while stack and h<stack[-1][1]:
                ind,height=stack.pop()
                maxarea=max(maxarea,(i-ind)*height)
                index=ind
            stack.append([index,h])
        for i,h in stack:
            maxarea=max(maxarea,(len(heights)-i)*h)
        return maxarea
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        index=0
        count=0
        res=[0]*len(temperatures)
        stack=[]
        for i,num in enumerate(temperatures):
            if not stack:
                stack.append([num,i])
            elif stack[-1][0]>=num:
                stack.append([num,i])
            else:
                while stack and stack[-1][0]<num:
                    ind=stack[-1][1]
                    stack.pop()
                    res[ind]=i-ind
                stack.append([num,i])
        return res
                

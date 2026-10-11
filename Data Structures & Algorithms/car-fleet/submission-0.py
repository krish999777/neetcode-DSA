class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        comb=[]
        fleet=0
        stack=[]
        for i in range(len(position)):
            comb.append([position[i],speed[i]])
        comb.sort(key=lambda x:x[0],reverse=True)
        for i in range (len(position)):
            time=(target-comb[i][0])/comb[i][1]
            if not stack or stack[-1]<time:
                fleet+=1
                stack.append(time)
        return fleet
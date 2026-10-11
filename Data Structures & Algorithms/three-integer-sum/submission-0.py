class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        sort_nums=sorted(nums)
        hashi=set()
        final=[]
        for i in range(len(sort_nums)):
            if sort_nums[i] in hashi:
                continue
            hashi.add(sort_nums[i])
            target=0-sort_nums[i]
            l=i+1
            r=len(sort_nums)-1
            while l<r:
                tsum=sort_nums[r]+sort_nums[l]
                if tsum==target:
                    final.append([sort_nums[i],sort_nums[l],sort_nums[r]])
                    l+=1
                    while sort_nums[l]==sort_nums[l-1] and l<r:
                        l+=1
                elif tsum>target:
                    r-=1
                else:
                    l+=1
        return final
                




        
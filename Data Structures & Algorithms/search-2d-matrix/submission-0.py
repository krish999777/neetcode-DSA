class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        l,b=len(matrix[0]),len(matrix)
        start,end=0,l*b-1
        while start<=end:
            mid=(start+end)//2
            if matrix[mid//l][mid%l]==target:
                return True
            elif matrix[mid//l][mid%l]>target:
                end=mid-1
            else:
                start=mid+1
        return False

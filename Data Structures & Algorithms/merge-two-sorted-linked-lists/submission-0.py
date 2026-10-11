# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        p1,p2=list1,list2
        dummy=list3=ListNode()
        while p1!=None and p2!=None:
            if p1.val>p2.val:
                list3.next=p2
                p2=p2.next
            else:
                list3.next=p1
                p1=p1.next
            list3=list3.next
        list3.next=p1 or p2
        return dummy.next
            
        
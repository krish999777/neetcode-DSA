# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        copy=dummy=head

        i=0
        while i<n:
            i+=1
            dummy=dummy.next
        if dummy:
            dummy=dummy.next  
        else: return copy.next
        while dummy:
            dummy=dummy.next
            head=head.next
        head.next=head.next.next if head.next.next else None
        return copy
        
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow,fast=head,head
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next
        curr,prev=slow.next,None
        while curr:
            nxt=curr.next
            curr.next=prev
            prev=curr
            curr=nxt
        nxt=head.next
        slow.next=None
        while prev and head:
            nxt=head.next
            head.next=prev
            head=head.next
            prev=prev.next
            head.next=nxt
            head=head.next
        


        
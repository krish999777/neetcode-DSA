/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head.next;
        if(fast==null){
            return;
        }
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode ptr=slow.next,prev=null;
        slow.next=null;
        while(ptr!=null){
            ListNode temp=ptr.next;
            ptr.next=prev;
            prev=ptr;
            ptr=temp;
        }
        ptr=head;
        while(ptr!=null&&prev!=null){
            ListNode temp=ptr.next;
            ListNode temp2=prev.next;
            ptr.next=prev;
            prev.next=temp;
            ptr=temp;
            prev=temp2;
        }
    }
}

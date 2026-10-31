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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode slow=head,fast=head;
        ListNode temp=null;
        while(fast!=null){
            int count=0;
            while(fast!=null&&count<k){
                fast=fast.next;
                count++;
            }
            if(count!=k){
                break;
            }
            count=0;
            ListNode prev=null,temp3=null;
            while(count<k){
                ListNode temp2=slow.next;
                if(prev==null){
                    temp3=slow;
                    slow.next=fast;
                }else{
                    slow.next=prev;
                }
                prev=slow;
                slow=temp2;
                count++;
            }
            if(temp!=null){
                temp.next=prev;
            }else{
                head=prev;
            }
            temp=temp3;
        }
        return head;
    }
}

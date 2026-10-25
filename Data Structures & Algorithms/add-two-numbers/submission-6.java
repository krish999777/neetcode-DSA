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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1=reverseNode(l1);
        // l2=reverseNode(l2);
        ListNode ptr1=l1,ptr2=l2;
        ListNode head=new ListNode(),ptr=head;
        int carry=0;
        while(ptr1!=null||ptr2!=null){
            int v1=ptr1==null?0:ptr1.val;
            int v2=ptr2==null?0:ptr2.val;
            int sum=v1+v2+carry;
            ListNode newNode=new ListNode(sum%10);
            ptr.next=newNode;
            ptr=newNode;
            carry=sum/10;
            if(ptr1!=null)
                ptr1=ptr1.next;
            if(ptr2!=null)
                ptr2=ptr2.next;
        }
        if(carry!=0){
            ptr.next=new ListNode(carry);
        }
        return head.next;
        
    }
    // private ListNode reverseNode(ListNode head){
    //     ListNode ptr=head,prev=null;
    //     while(ptr!=null){
    //         ListNode temp=ptr.next;
    //         ptr.next=prev;
    //         prev=ptr;
    //         ptr=temp;
    //     }
    //     return prev;
    // }
}

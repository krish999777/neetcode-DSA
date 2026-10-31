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
    public ListNode mergeKLists(ListNode[] lists) {
        int l=lists.length;
        if(l==0){
            return null;
        }
        int top=l;
        while(top>1){
            int index=0;
            int i=0;
            while(i<top){
                ListNode dummy=new ListNode(),ptr=dummy;
                if(i+1<top){
                    ListNode ptr1=lists[i++];
                    ListNode ptr2=lists[i++];
                    while(ptr1!=null&&ptr2!=null){
                        if(ptr1.val<ptr2.val){
                            ptr.next=ptr1;
                            ptr1=ptr1.next;
                        }else{
                            ptr.next=ptr2;
                            ptr2=ptr2.next;
                        }
                        ptr=ptr.next;
                    }
                    if(ptr1!=null){
                        ptr.next=ptr1;
                    }
                    if(ptr2!=null){
                        ptr.next=ptr2;
                    }
                }else{
                    dummy.next=lists[i++];
                }
                lists[index++]=dummy.next;
            }
            top=index;
        }
        return lists[0];
    }
}

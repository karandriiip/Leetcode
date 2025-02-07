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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        int size=0;
        ListNode temp=head;
        ListNode tail=null;

        while(temp!=null){
            size++;
            tail=temp;
            temp=temp.next;
        }

        if(k>size){
            k=k%size;
        }
        if(size==k || k==0){
            return head;
        }

        tail.next=head;
        int rev=size-k;
        ListNode po=head;
        while(--rev>0){
            po=po.next;
        }
        head=po.next;
        po.next=null;
        return head;
    }
}
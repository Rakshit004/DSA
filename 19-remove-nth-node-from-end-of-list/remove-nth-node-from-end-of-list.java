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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null||n==0)
         {
            return null;
         }
         int c=1;
         ListNode tail=head;
         
         while(tail.next!=null)
         {
            c++;
            tail=tail.next;
         }
         if(n==c)
         {
            return head.next;
         }
         
         ListNode temp=head;
          if(n<=c)
          { n=(c-n);
            
             for(int i=0;i<n-1;i++)
             {
                temp=temp.next;
             }
             temp.next=temp.next.next;
          }
          return head;
    }
}
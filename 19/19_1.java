/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode p = node, q = node;
        while(n != -1) {  //往后移动n+1个节点
            q = q.next;
            n--;
            // detect exceed
            if (first == null) {
              return dummy.next;
            }
        }
        while(q != null) {
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;
        return node.next;
    }
}

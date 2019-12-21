//2ms 44.8MB
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);//头节点
        ListNode node = res;//保存待会要返回的头节点
        ListNode p = l1, q = l2;//保存l1, l2
        int cnt = 0;
        while(p != null || q != null) {
            int x, y;
            if(p != null) { x = p.val; } else {x = 0;}
            if(q != null) { y = q.val; } else {y = 0;}
            res.next = new ListNode((x + y + cnt) % 10);
            cnt = (x + y + cnt) / 10;
            if(p != null) {
                p = p.next;
            }
            if(q != null) {
                q = q.next;
            }
            res = res.next;
        }
        if(cnt != 0) {
            res.next = new ListNode(cnt);
        }
        return node.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> array = new ArrayList<>();
        ListNode node = new ListNode(0);
        ListNode res = node;
        for(ListNode list: lists) {
            while(list != null) {
                array.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(array);
        for(Integer i: array) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return res.next;
    }
}

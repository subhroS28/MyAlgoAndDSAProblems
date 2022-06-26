package subhro.sde_sheet.Other.LinkedList;

/**
 * Question - https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *            https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1/
 */
public class RemoveDuplicatesFromSortedList {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    Node removeDuplicates(Node head)
    {
        if(head==null || head.next == null){
            return head;
        }

        Node fast=head;
        while(fast.next!=null){
            if(fast.data == fast.next.data){
                fast.next = fast.next.next;
            }else{
                fast = fast.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == pre.val){
                pre.next = cur.next;
                cur = cur.next;
            }
            else{
                pre = pre.next;
                cur = pre.next;
            }
        }
        return head;
    }
}

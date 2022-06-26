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
}
